package com;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DuplicateFileRemover {
    public static void main(String[] args) {
        File folder = new File("path/to/folder"); // 替换为目标文件夹的路径

        // 存储重名文件的集合
        Map<String, File> fileMap = new HashMap<>();

        // 遍历文件夹中的文件
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String name = file.getName();
                    String extension = name.substring(name.lastIndexOf("."));
                    String baseName = name.substring(0, name.lastIndexOf("."));

                    // 检查是否存在同名的另一种文件类型
                    String targetExtension = "";
                    if (extension.equalsIgnoreCase(".jpg")) {
                        targetExtension = ".mp4";
                    } else if (extension.equalsIgnoreCase(".mp4")) {
                        targetExtension = ".jpg";
                    }

                    File targetFile = new File(file.getParent(), baseName + targetExtension);

                    // 将文件名添加到重名文件集合中
                    if (targetFile.exists() && targetFile.isFile()) {
                        if (!fileMap.containsKey(baseName)) {
                            fileMap.put(baseName, file);
                        } else {
                            File existingFile = fileMap.get(baseName);

                            // 删除重复的文件
                            if (file.lastModified() < existingFile.lastModified()) {
                                file.delete();
                                System.out.println("Deleted " + file.getName());
                            } else {
                                existingFile.delete();
                                System.out.println("Deleted " + existingFile.getName());
                                fileMap.put(baseName, file);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Empty folder");
        }
    }
}