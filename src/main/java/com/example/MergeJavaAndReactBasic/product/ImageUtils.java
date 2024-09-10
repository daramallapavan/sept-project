package com.example.MergeJavaAndReactBasic.product;

import java.io.ByteArrayOutputStream;
import java.util.zip.Deflater;

public class ImageUtils {

    public static  byte[] compressImage(byte[] data){
        Deflater deflater=new Deflater();
        deflater.setLevel( Deflater.BEST_COMPRESSION );
        deflater.setInput( data );
        deflater.finish();

        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(data.length);
        byte[] tmp=new byte[4*1024];

        while (!deflater.finished()){
          int size=  deflater.deflate( tmp );
          byteArrayOutputStream.write( tmp,0,size );
        }

        try{
            byteArrayOutputStream.close();
        }catch (Exception e){

        }

        return byteArrayOutputStream.toByteArray();
    }


}
