package com;

/**
 * @author xingchen
 * @version V1.0
 * @Package com
 * @date 2023/8/20 15:19
 */
import java.io.File;

public class FileRename {
    public static void main(String[] args) {
        String folderPath = "E:\\Test\\新建文件夹"; // 文件夹路径
        String newExtension = ".jpg"; // 新的文件后缀名

        // 创建表示文件夹的File对象
        File folder = new File(folderPath);

        // 获取文件夹中的所有文件
        File[] files = folder.listFiles();

        // 遍历文件数组并逐个重命名
        if (files != null) {
            for (File file : files) {
                String oldName = file.getName(); // 原文件名
                String newName = oldName + newExtension; // 新文件名
                File newFile = new File(folderPath, newName);

                // 重命名文件
                if (file.renameTo(newFile)) {
                    System.out.println("文件重命名成功： " + oldName + " -> " + newName);
                } else {
                    System.out.println("文件重命名失败： " + oldName);
                }
            }
        }
    }
}