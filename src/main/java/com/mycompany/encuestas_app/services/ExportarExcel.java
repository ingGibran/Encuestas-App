package com.mycompany.encuestas_app.services;

import com.mycompany.encuestas_app.vistas.respuestas.ResultadosEncuestaComplejaFrame;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Encuesta;
import modelos.Pregunta;
import modelos.Respuesta;

/**
 *
 * @author alexpy
 */
public class ExportarExcel {

        private final EncuestaService encuestaService = new EncuestaService();
        private final PreguntaService preguntaService = new PreguntaService();
        private final RespuestaService respuestaService = new RespuestaService();
        private final UsuarioService usuarioService = new UsuarioService();
        
        public ExportarExcel() {}
        
        public void Reportar(String nombreArchivo) throws Exception {
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Resultados Consolidados");

                CellStyle headerStyle = getHeaderStyle(workbook);
                CellStyle titleStyle = getTitleStyle(workbook);

                int rowNum = 0;

                try {
                    List<Encuesta> todasLasEncuestas = encuestaService.getAllEncuestas();

                    for (Encuesta encuesta : todasLasEncuestas) {
                        Row titleRow = sheet.createRow(rowNum++);
                        Cell titleCell = titleRow.createCell(0);
                        titleCell.setCellValue("ENCUESTA: " + encuesta.getNombre().toUpperCase());
                        titleCell.setCellStyle(titleStyle);

                        sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(
                                titleRow.getRowNum(), titleRow.getRowNum(), 0, 3)); 

                        Row headerRow = sheet.createRow(rowNum++);
                        headerRow.createCell(0).setCellValue("Pregunta");
                        headerRow.createCell(1).setCellValue("ID Usuario");
                        headerRow.createCell(2).setCellValue("Respuesta (Valor)");
                        headerRow.createCell(3).setCellValue("Orden Pregunta");
                        for(int i = 0; i < 4; i++) { headerRow.getCell(i).setCellStyle(headerStyle); }

                        List<Pregunta> preguntas = preguntaService.getPreguntasPorEncuesta(encuesta.getId_encuesta());

                        for (Pregunta pregunta : preguntas) {
                                
                            List<Respuesta> respuestas = respuestaService.getRespuestasPorPregunta(pregunta.getId_pregunta());

                            
                            
                            for (Respuesta respuesta : respuestas) {
                                Row dataRow = sheet.createRow(rowNum++);

                                dataRow.createCell(0).setCellValue(pregunta.getTexto());

                                dataRow.createCell(1).setCellValue(respuesta.getId_usuario()); 

                                dataRow.createCell(2).setCellValue(respuesta.getValor());

                                dataRow.createCell(3).setCellValue(pregunta.getOrder());
                            }
                        }

                        rowNum++; 
                    }

                    for(int i = 0; i < 4; i++) {
                        sheet.autoSizeColumn(i);
                    }

                    try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo)) {
                        workbook.write(fileOut);
                    }

                } finally {
                    workbook.close();
                }
            }   
        

        private CellStyle getHeaderStyle(Workbook workbook) {
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            style.setFont(font);
            style.setBorderBottom(BorderStyle.THIN);
            return style;
        }

        private CellStyle getTitleStyle(Workbook workbook) {
            CellStyle style = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            font.setFontHeightInPoints((short) 14); 
            style.setFont(font);
            return style;
        }

        
        
}
