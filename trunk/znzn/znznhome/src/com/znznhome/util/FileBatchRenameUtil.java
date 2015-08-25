package com.znznhome.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;

public class FileBatchRenameUtil {
	
	public static void main(String[] args) {
		FileBatchRenameUtil util = new FileBatchRenameUtil();
		File dir = new File("E:\\temppic");
		util.renameBatch(dir);
		System.out.println("rename over");
	}
	
	public void renameBatch(File dir) {
		File files[] = dir.listFiles();
		for(int i=0; i<files.length; i++) {
			File file = files[i];
			if(file.isDirectory()){
				File[] pices = this.getPics(file);
				for(File pic : pices) {
					rename(pic, "E:\\temppic\\");
				}
				renameBatch(file);
			}
		}
		
	}
	
	public File[] getPics(File dir){
		File files[] = dir.listFiles(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				if (name.endsWith(".jpg") || name.endsWith(".JPG")) {
					return true;
				}
				return false;
			}
		});
		return files;
	}
	
	public void rename(File file, String dir)  {
		if(file.isFile()) {
			File newFile = new File(dir + getNewName());
			boolean b = file.renameTo(newFile);
		}
	}
	
	public String getNewName() {
		UUID uuid = UUID.randomUUID();
		return uuid + ".jpg";
	}

}
