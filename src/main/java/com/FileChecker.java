package com;

/**
 * @author xingchen
 * @version V1.0
 * @Package com
 * @date 2023/8/29 20:32
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileChecker {

    public static void main(String[] args) {
        String folderPath = "D:\\wx\\WeChat Files\\wxid_2gnnpm0oh08i22\\FileStorage\\Video\\2023-10"; // 替换为要检查的文件夹路径

        String targetFolderPath = "F:\\MP4"; // 目标文件夹的路径

        File folder = new File(folderPath);
        File[] files1 = folder.listFiles();
        int res=0;
        for(File file:files1){
            if (file.exists() && file.isDirectory()) {
                if (file != null) {
//                    fileCopy(file);
//                    deleteFile(file);
                } else {
                    deleteFile(file);
                    res++;
                }
            } else {
                System.out.println("文件夹不存在或不是一个有效的目录.");
            }
        }
        System.out.println("文件夹为空."+res);




        // 生成统计文件的相关代码...
    }

    public static void deleteJPGFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null&&file.equals(".jpg")) {
                for (File f : files) {
                    deleteFile(f); // 递归删除子文件或子文件夹
                }
            }
        }

        if (file.delete()) {
            System.out.println("文件删除成功：" + file.getAbsolutePath());
        } else {
            System.out.println("文件删除失败：" + file.getAbsolutePath());
        }
    }


    public static void deleteFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null&&file.equals(".nomedia")) {
                for (File f : files) {
                    deleteFile(f); // 递归删除子文件或子文件夹
                }
            }
        }

        if (file.delete()) {
            System.out.println("文件删除成功：" + file.getAbsolutePath());
        } else {
            System.out.println("文件删除失败：" + file.getAbsolutePath());
        }
    }

    public static void fileCopy(File filel){
        String targetFolderPath = "F:\\MP4"; // 目标文件夹的路径

        File[] files = filel.listFiles();
        for (File file:files){
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
