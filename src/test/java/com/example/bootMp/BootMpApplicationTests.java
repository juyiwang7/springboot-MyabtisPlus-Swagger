package com.example.bootMp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootMpApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void Str2Map(){
		String answer = "[{\"RESULTS\":{\"COLUMNS\":[\"runoob_id\",\"runoob_title\",\"runoob_author\",\"submission_date\"],\"DATA\":[[1,\"学习 PHP\",\"菜鸟教程\",\"2020-06-05\"]]},\"SUCCEEDED\":true,\"STATEMENT\":\"select * from runoob_tbl\",\"EXECUTIONTIME\":4,\"EXECUTIONPLANRAW\":{\"COLUMNS\":[\"id\",\"select_type\",\"table\",\"type\",\"possible_keys\",\"key\",\"key_len\",\"ref\",\"rows\",\"filtered\",\"Extra\"],\"DATA\":[[\"1\",\"SIMPLE\",\"runoob_tbl\",\"ALL\",null,null,null,null,\"1\",\"100.00\",null]]},\"EXECUTIONPLAN\":{\"COLUMNS\":[\"id\",\"select_type\",\"table\",\"type\",\"possible_keys\",\"key\",\"key_len\",\"ref\",\"rows\",\"filtered\",\"Extra\"],\"DATA\":[[\"1\",\"SIMPLE\",\"runoob_tbl\",\"ALL\",null,null,null,null,\"1\",\"100.00\",null]]}}]";
		List<Object> list = JSON.parseArray(answer);
		List<Map<String,Object>> listw = new ArrayList<>();
		for (Object object : list){
			Map <String,Object> ret = (Map<String, Object>) object;//取出list里面的值转为map
			listw.add(ret);
		}
		//OBJ 转map
		JSONObject obj= JSON.parseObject(listw.get(0).get("RESULTS").toString());
		Map<String,Object> data = new HashMap<>();
		Iterator it =obj.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
			data.put(entry.getKey().trim(), entry.getValue());
		}
		//str转list  [1,"学习 PHP","菜鸟教程","2020-06-05"]
		List<String> listStr= JSONArray.parseArray(data.get("DATA").toString(),String.class);
		List<String> columnsStr= JSONArray.parseArray(data.get("COLUMNS").toString(),String.class);

		List<Object> listStrs= JSONArray.parseArray(listStr.get(0),Object.class);
		Map<String,String> answerMap = new HashMap<>();
		int index =0;
		for (Object s:listStrs) {
			answerMap.put(columnsStr.get(index),s.toString());
			index++;
		}
	}

	@Test
	public void executeResultStr2Map(){
		String executeResult = "[{\"COLUMNS \":[\"runoob_id \",\"runoob_title \",\"runoob_author \",\"submission_date \"],\"DATA \":[[1,\"学习 PHP \",\"菜鸟教程 \",\"2020 - 06 - 05 \"]]}]";
		List<Object> list = JSON.parseArray(executeResult);
		List<Map<String,Object>> listw = new ArrayList<>();
		for (Object object : list){
			Map <String,Object> ret = (Map<String, Object>) object;//取出list里面的值转为map
			listw.add(ret);
		}
		//OBJ 转map {"DATA ":[[1,"学习 PHP ","菜鸟教程 ","2020 - 06 - 05 "]],"COLUMNS ":["runoob_id ","runoob_title ","runoob_author ","submission_date "]}

		JSONObject obj= JSON.parseObject(listw.get(0).toString());
		Map<String,Object> data = new HashMap<>();
		Iterator it =obj.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
			data.put(entry.getKey().trim(), entry.getValue());
		}

		List<String> listStr= JSONArray.parseArray(data.get("DATA").toString(),String.class);
		//数据数（行数）
		int rowSize = listStr.size();
		List<String> columnsStr= JSONArray.parseArray(data.get("COLUMNS").toString(),String.class);
		Map<String,List<String>> answerMap = new HashMap<>();
		for (int i = 0;i<rowSize;i++){
			// 第i行数据
			List<Object> listStrs= JSONArray.parseArray(listStr.get(i),Object.class);
			int index =0;
			//  第i行数据的遍历
			for (Object s:listStrs) {
				List<String> columnList;
				columnList = answerMap.get(columnsStr.get(index));
				if (columnList == null)
					columnList = new ArrayList<>();
				columnList.add(s.toString().trim().replaceAll("　", ""));
				answerMap.put(columnsStr.get(index).replaceAll("　", ""),columnList);
				index++;
				"学习 PHP".trim().replaceAll("　", "");
			}

		}
	}


	@Test
	public void ttt(){
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("eqweq");
		treeSet.add("gfdgd");
		treeSet.add("e2q");
		treeSet.add("7utj");
		treeSet.add("mgsdgfa");

		Iterator<String> it = treeSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}


}
