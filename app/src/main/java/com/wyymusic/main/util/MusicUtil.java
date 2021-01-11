package com.wyymusic.main.util;

import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author tbx
 * @date 2021/1/10
 * target:
 * time: 2021/1/10
 * God Bless my code!
 **/
public class MusicUtil {

    public static void downloadMusic(String targeturl, String musicName) {
        int count;
        try {
            URL url = new URL(targeturl);
            URLConnection conexion = url.openConnection();
            conexion.connect();
            // this will be useful so that you can show a tipical 0-100% progress bar
            int lenghtOfFile = conexion.getContentLength();

            // downlod the file
            InputStream input = new BufferedInputStream(url.openStream());
            OutputStream output = new FileOutputStream("/sdcard/Music/" + musicName + ".mp3");

            byte data[] = new byte[1024];
            long total = 0;
            while ((count = input.read(data)) != -1) {
                total += count;
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save(String inputText, Context context) {
        int count;
            FileOutputStream out = null;
            BufferedWriter writer = null;
            try {
                File file = new File("storage/self/primary/Music/" + inputText + ".mp3");
                out = new FileOutputStream(file);
                writer = new BufferedWriter(new OutputStreamWriter(out));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
            }
        }
    }

    public static void out(String name,Context context) {
        try {
            File file = new File(Environment.getExternalStorageDirectory(),name);
            System.out.println(file.getName());
            FileOutputStream outputStream = new FileOutputStream(file);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
