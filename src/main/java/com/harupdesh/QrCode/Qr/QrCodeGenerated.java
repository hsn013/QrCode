package com.harupdesh.QrCode.Qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.harupdesh.QrCode.entity.Student;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class QrCodeGenerated {

    public static void generatedQrCode(Student student) throws WriterException,IOException {
        String qrCodePath= "C:\\Users\\Admin\\Desktop\\Spring Boot\\QrCode\\src\\main\\java\\com\\harupdesh\\QrCode\\Qr";
        String qrCodeName= qrCodePath+student.getFirstName()+student.getId()+"QRCODE.png";
        var qrCodeWrite = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWrite.encode("ID" + student.getId() + "\n" +
                                                 "firstName" + student.getFirstName() + "\n" +
                                                 "lastName" + student.getLastName() + "\n" +
                                                 "Email" + student.getEmail() + "\n" +
                                                 "Mobile no." + student.getMobile() + "\n", BarcodeFormat.QR_CODE,400,400);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);
    }

}
