package com.example.bootMp;

import com.zhixiangli.code.similarity.CodeSimilarity;
import com.zhixiangli.code.similarity.strategy.CosineSimilarity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootMpApplicationTests {

	//测试相似度检测代码
	@Test
	public void contextLoads() {
		String a = "public static void main(String[] args) {System.out.println(1);}";
		String b = "public static void main(String[] args) {System.out.println(2);}";
		CodeSimilarity codeSimilarity = new CodeSimilarity();
		System.out.println(codeSimilarity.get(a, b));

		CodeSimilarity cosineSimilarity = new CodeSimilarity(new CosineSimilarity());
		System.out.println(cosineSimilarity.get(a, b));
	}

}
