package com.高并发;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFolderPath = "F:\\新建文件夹"; // 源文件夹的路径
        String targetFolderPath = "F:\\MP4"; // 目标文件夹的路径

        File sourceFolder = new File(sourceFolderPath);
        File[] files = sourceFolder.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".mp4")) {
                    String fileName = file.getName();

                    File targetFolder = new File(targetFolderPath);
                    if (!targetFolder.exists()) {
                        targetFolder.mkdirs(); // 创建目标文件夹
                    }

                    File targetFile = new File(targetFolderPath + File.separator + fileName);

                    try (FileInputStream fis = new FileInputStream(file);
                         FileOutputStream fos = new FileOutputStream(targetFile)) {
                        byte[] buffer = new byte[1024];
                        int length;
                        while ((length = fis.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }

                        System.out.println("文件复制成功：" + targetFile.getAbsolutePath());
                    } catch (IOException e) {
                        System.out.println("文件复制失败：" + e.getMessage());
                    }
                }
            }
        }
    }
}