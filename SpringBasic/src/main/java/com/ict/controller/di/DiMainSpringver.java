package com.ict.controller.di;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.ict.controller.di.classfile.BalladSinger;
import com.ict.controller.di.classfile.Broadcast;
import com.ict.controller.di.classfile.Library;
import com.ict.controller.di.classfile.PopSinger;
import com.ict.controller.di.classfile.Singer;
import com.ict.controller.di.classfile.Stage;

public class DiMainSpringver {

	public static void main(String[] args) {
		
		// 공장 주소 2개 배열로 처리
		String[] address = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
                "file:src/main/webapp/WEB-INF/spring/root-context2.xml"};
		
		// root-context라는 공장에 저장된 객체를 뽑아서 써야합니다.
		// 1. 가져오기 위한 호출코드를 작성해보겠습니다.
		
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-*.xml");
						                       
		
		
		// 2. 공장 내부 객체 가져오기
		// context.getBeans("공쟁 내부 명칭", 클래스파일명.class);
//		Singer singer = context.getBean("singer", Singer.class);
		
		// 3. 가져온 객체 사용하기
		
//		singer.sing();
		
		// 4. 여러분들이 직접 Stage를 가져다가 실행시키는 코드를 작성해주세요
//		Stage stage = context.getBean("stage", Stage.class);
		
//		stage.perform();
		
		
//		Broadcast broadcast = context.getBean("broadcast", Broadcast.class );
		
//		broadcast.OnAir();
		
		
//		BalladSinger balladSinger = context.getBean("balladSinger",BalladSinger.class );
			
//		balladSinger.sing();
		
		
		
//		PopSinger popSinger = context.getBean("popSinger",PopSinger.class);
//		popSinger.Sing();
		
		
		// 7. 수동 생성 bean인 stage1 가져와서 사용하기
		Stage stage1 = context.getBean("stage1", Stage.class);
		stage1.perform();
		
		Stage stage2 = context.getBean("stage2" ,Stage.class);
		stage2.perform();
		
		
		// 8. library 가져와 실행하기
		
//		Library library = context.getBean("library1",Library.class);
//		library.browse();
	}

}