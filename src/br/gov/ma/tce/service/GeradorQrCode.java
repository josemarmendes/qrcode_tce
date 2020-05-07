package br.gov.ma.tce.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class GeradorQrCode {
	private static final String QR_CODE_IMAGE_PATH = "./QRCodeDocumento.png";

	// Este m�todo ir� gerar um QR Code com o texto - "Este � o meu primeiro QR
	// Code" e salv�-lo no local especificado

	private static void generateQRCodeImage(String text, int width, int height, String filePath)
			throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

	/*
	 * Este m�todo leva o texto a ser codificado, a largura e a altura do QR Code, e
	 * retorna o QR Code na forma de uma matriz de bytes
	 */
	/*
	 * Se deseja retornar a imagem do QR Code como resposta a uma solicita��o http.
	 * Voc� pode retornar a matriz de bytes no corpo da sua resposta http usando
	 * este m�todo
	 */
	@SuppressWarnings("unused")
	/*
	 * private byte[] getQRCodeImage(String text, int width, int height) throws
	 * WriterException, IOException { QRCodeWriter qrCodeWriter = new
	 * QRCodeWriter(); BitMatrix bitMatrix = qrCodeWriter.encode(text,
	 * BarcodeFormat.QR_CODE, width, height);
	 * 
	 * ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
	 * MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream); byte[]
	 * pngData = pngOutputStream.toByteArray(); return pngData; }
	 */

	public static void main(String[] args) {
		try {
			generateQRCodeImage("www.tce.ma.gov.br/sae", 350, 350, QR_CODE_IMAGE_PATH);
		} catch (WriterException e) {
			System.out.println("Could not generate QR Code, WriterException :: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not generate QR Code, IOException :: " + e.getMessage());
		}
	}
}
