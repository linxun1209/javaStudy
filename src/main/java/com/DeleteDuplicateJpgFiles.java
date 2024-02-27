package com;

import java.io.File;

public class DeleteDuplicateJpgFiles {
    public static void main(String[] args) {
        String folderPath = "D:\\wx\\WeChat Files\\wxid_2gnnpm0oh08i22\\FileStorage\\Video\\2024-01"; // 替换为实际文件夹的路径
        
        // 获取文件夹中的所有文件
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        
        // 遍历文件列表
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile() && files[i].getName().endsWith(".jpg")) {
                String fileName = files[i].getName();
                String filePath = files[i].getAbsolutePath();
                
                // 检查文件夹中是否存在重名的mp4文件
                String mp4FilePath = filePath.replace(".jpg", ".mp4");
                File mp4File = new File(mp4FilePath);
                
                if (mp4File.exists()) {
                    // 存在重名的mp4文件，删除jpg文件
                    if (files[i].delete()) {
                        System.out.println("已成功删除文件：" + fileName);
                    } else {
                        System.out.println("无法删除文件：" + fileName);
                    }
                }
            }
        }
    }
}