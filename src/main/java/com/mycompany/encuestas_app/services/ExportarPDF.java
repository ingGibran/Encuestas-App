package com.mycompany.encuestas_app.services;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.io.image.ImageDataFactory;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import modelos.Encuesta;
import modelos.Pregunta;
import modelos.Respuesta;
import com.mycompany.encuestas_app.services.PreguntaService;
import com.mycompany.encuestas_app.services.RespuestaService;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author alexpy
 */
public class ExportarPDF {

                private final PreguntaService preguntaService = new PreguntaService();
                private final RespuestaService respuestaService = new RespuestaService();


                public void generarReporteDeEncuesta(Encuesta encuesta, String nombreArchivo) throws Exception {
                if (encuesta == null || encuesta.getId_encuesta() == null) {
                    throw new IllegalArgumentException("La encuesta y su ID no pueden ser nulos.");
                }

                PdfWriter writer = new PdfWriter(nombreArchivo);
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);

                try {
                    document.add(new Paragraph("Reporte de Resultados de Encuesta")
                            .setTextAlignment(TextAlignment.CENTER)
                            .setFontSize(24)
                            .setBold());
                    document.add(new Paragraph("Encuesta: " + encuesta.getNombre())
                            .setTextAlignment(TextAlignment.CENTER)
                            .setFontSize(18)
                            .setMarginBottom(20));

                    List<Pregunta> preguntas = preguntaService.getPreguntasPorEncuesta(encuesta.getId_encuesta());

                    if (preguntas.isEmpty()) {
                        document.add(new Paragraph("No hay preguntas para esta encuesta.")
                                .setTextAlignment(TextAlignment.CENTER));
                        return;
                    }

                    for (Pregunta pregunta : preguntas) {
                        List<Respuesta> respuestas = respuestaService.getRespuestasPorPregunta(pregunta.getId_pregunta());

                        if (!respuestas.isEmpty()) {
                            Map<Integer, Integer> conteoRespuestas = new HashMap<>();
                            for (Respuesta r : respuestas) {
                                conteoRespuestas.put(r.getValor(), conteoRespuestas.getOrDefault(r.getValor(), 0) + 1);
                            }

                            JFreeChart chart = null;

                            if (pregunta.isEs_principal() && conteoRespuestas.keySet().size() <= 5) {
                                chart = createPieChart("Respuestas para: " + pregunta.getTexto(), conteoRespuestas);
                            } else {
                                chart = createBarChart("Respuestas para: " + pregunta.getTexto(), conteoRespuestas);
                            }

                            ByteArrayOutputStream chartOutputStream = new ByteArrayOutputStream();
                            ChartUtils.writeChartAsPNG(chartOutputStream, chart, 600, 400);
                            Image chartImage = new Image(ImageDataFactory.create(chartOutputStream.toByteArray()));

                            document.add(new Paragraph("\nPregunta: " + pregunta.getTexto())
                                    .setBold()
                                    .setFontSize(14)
                                    .setMarginTop(15)
                                    .setMarginBottom(5));
                            document.add(chartImage.setTextAlignment(TextAlignment.CENTER));
                            document.add(new Paragraph("\n"));
                        } else {
                            document.add(new Paragraph("\nPregunta: " + pregunta.getTexto())
                                    .setBold()
                                    .setFontSize(14)
                                    .setMarginTop(15)
                                    .setMarginBottom(5));
                            document.add(new Paragraph("No se encontraron respuestas para esta pregunta.")
                                    .setTextAlignment(TextAlignment.CENTER)
                                    .setItalic());
                            document.add(new Paragraph("\n"));
                        }
                    }

                } finally {
                    document.close();
                }
            }


            private JFreeChart createPieChart(String title, Map<Integer, Integer> data) {
                DefaultPieDataset<String> dataset = new DefaultPieDataset<>();
                for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                    dataset.setValue("Opción " + entry.getKey(), entry.getValue());
                }

                JFreeChart chart = ChartFactory.createPieChart(
                        title,
                        dataset,
                        true, // include legend
                        true, // tooltips
                        false // urls
                );
                chart.setBackgroundPaint(Color.white);
                return chart;
            }

            private JFreeChart createBarChart(String title, Map<Integer, Integer> data) {
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                    dataset.addValue(entry.getValue(), "Conteo", "Opción " + entry.getKey());
                }

                JFreeChart chart = ChartFactory.createBarChart(
                        title,
                        "Opciones de Respuesta",
                        "Número de Respuestas",
                        dataset,
                        PlotOrientation.VERTICAL,
                        true,
                        true, 
                        false
                );

                chart.setBackgroundPaint(Color.white);
                chart.getCategoryPlot().setRenderer(new org.jfree.chart.renderer.category.BarRenderer());
                chart.getCategoryPlot().getRenderer().setSeriesPaint(0, new Color(79, 129, 189));
                chart.getCategoryPlot().setOutlineStroke(new BasicStroke(1.0f));
                return chart;
            }
}
