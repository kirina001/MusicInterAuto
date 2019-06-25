package com.music.test;

import java.util.List;

import com.music.common.ExcelReader;
import com.music.common.ExcelWriter;
import com.music.common.GetDate;
import com.music.common.report;
import com.music.inter.DataDrivenOfInter;

public class TestForData2 {

	public static void main(String[] args) {

		GetDate getDate = new GetDate();
		// 打开Excel表进行读取
		ExcelReader excelR = new ExcelReader("cases/music_auto1.xlsx");
//		excelR.useSheet("新增用户");
//		excelR.useSheet("登录");
//		excelR.useSheet("曲目管理");
//		excelR.useSheet("下载曲目");
//		excelR.useSheet("编辑曲目");
		excelR.useSheet("删除曲目");
		// 复制用例中的内容到结果中，并执行之后的写入操作
		ExcelWriter excelW = new ExcelWriter("cases/music_auto1.xlsx", "cases/Res-music_auto" +getDate.getDate() + ".xlsx");
//		excelW.useSheet("新增用户");
//		excelW.useSheet("登录");
//		excelW.useSheet("曲目管理");
//		excelW.useSheet("下载曲目");
//		excelW.useSheet("编辑曲目");
		excelW.useSheet("删除曲目");
		


		// 创建关键字类
		DataDrivenOfInter inter = new DataDrivenOfInter(excelW);
//		inter.saveCookie();//保存cookie
		// 通过list读取每行中的内容
		List<String> list = null;
		
		// 遍历excel当中每一行，执行关键字并将结果写入对应单元格
		for (int caseline = 0; caseline < excelR.rows; caseline++) {
			// 读取excel当中的每行内容
			System.out.println(excelR.readLine(caseline));
			// 调用时，赋值给关键字类中的成员变量line
			inter.line = caseline;
			// 读取每行中的内容
			list = excelR.readLine(caseline);
			// 判断第一第二列是否为空，第一、二列为空才是要执行的
			if ((list.get(0) != null || list.get(1) != null)
					&& (!list.get(0).equals("null") || !list.get(1).equals("null"))
					&& (list.get(0).length() > 0 || list.get(1).length() > 0)) {
				;
			} else {
				// trycatch块保证每条用例即使报错也能继续往下执行
				try {
					// 通过Excel表中填写的关键字判断调用哪个方法执行
					switch (list.get(3)) {
					case "post":
						inter.testPost(list.get(4), list.get(5));
						break;
					case "postJson":
						inter.testPostJson(list.get(4), list.get(5));
						break;
					case "postMutipart":
						inter.testPostMutipart(list.get(4), list.get(5));
						break;
					case "get":
						inter.testGet(list.get(4), list.get(5));
						break;
					case "getMutipart":
						inter.testGetMutipart(list.get(4), list.get(5));
						break;
					case "putJson":
						inter.testPutJson(list.get(4), list.get(5));
						break;
					case "deleteJson":
						inter.testDeleteJson(list.get(4), list.get(5));
						break;
					case "testPostRest":
						inter.testPostRest(list.get(4), list.get(5));
						break;
					case "savecookie":
						inter.saveCookie();
						break;
					case "clearcookie":
						inter.clearCookie();
						break;
					case "addHeader":
						inter.addHeader(list.get(4));
						break;
					case "saveParam":
						inter.saveParam(list.get(4), list.get(5));
						break;
					}
					// 通过excel表中填写的校验方法确定
					switch (list.get(7)) {
					case "equal":
						inter.assertSame(list.get(9), list.get(10));
						break;
					case "contain":
						inter.assertContains(list.get(9), list.get(10));
						break;
					
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		//保存写入的结果文件
		excelW.save();

	}
	
}
