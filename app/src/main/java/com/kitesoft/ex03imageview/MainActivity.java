package com.kitesoft.ex03imageview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // xml에서 만들 뷰들을 제어하기 위한 참조변수들을 MainActivity의 멤버변수로 선언
    ImageView iv;
    Button btnAus, btnBel, btnCan, btnKor;

    // 이미지뷰를 클릭하였을 때 차례로 국기 이미지가 변경되는 코드를 연습하기 위한 int형 변수
    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml에서 작성한 View들 id로 찾아와서 참조하기
        iv= findViewById(R.id.iv);
        btnAus= findViewById(R.id.btn01);
        btnBel= findViewById(R.id.btn02);
        btnCan= findViewById(R.id.btn03);
        btnKor= findViewById(R.id.btn04);

        // 버튼 4개의 클릭에 반응하기 위한 리스너 설정
        // 리스너는 저 아래 onCreate()메소드 밖에 MainActivity의 멤버변수로서 생성하였음.
        // 1개의 리스너객체가 4개의 버튼 클릭에 모두 반응
        btnAus.setOnClickListener(listener);
        btnBel.setOnClickListener(listener);
        btnCan.setOnClickListener(listener);
        btnKor.setOnClickListener(listener);

        //이미지뷰를 클릭하는 것을 듣는 리스너 생성 및 추가
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //이미지뷰가 보여주는 이미지를 변경하기 : 특별한 상황이 아니면 이미지의 파일명 알파벳 abc순으로 이미지가 관리되고 있어서
                //처음 이미지에 숫자 1을 더하면 다음그림을 지정할 수 있게됨. [ 정확한 내용은 R.java에 대한 이해 필요 ]
                iv.setImageResource(R.drawable.australia+num);

                //보여주는 이미지의 번호를 변경..최대 6개만 반복적으로 돌아가면서 보여주도록..
                num++;
                if(num>6){
                    num=0;
                }

            }
        });


    }//onCreate Method..

    //클릭을 듣는 리스너 객체 생성
    View.OnClickListener listener= new View.OnClickListener(){

        //콜백메소드
        @Override
        public void onClick(View view) {
            //버튼을 클릭하면 실행되는 영역

            int id= view.getId();//4개의 버튼 중 현재 클릭된 버튼뷰의 id들 얻어오기
            switch ( id ){
                case R.id.btn01:
                    //이미지뷰가 보여주는 이미지를 변경하기
                    iv.setImageResource(R.drawable.australia);
                    break;

                case R.id.btn02:
                    iv.setImageResource(R.drawable.belgium);
                    break;

                case R.id.btn03:
                    iv.setImageResource(R.drawable.canada);
                    break;

                case R.id.btn04:
                    iv.setImageResource(R.drawable.korea);
                    break;
            }

        }
    };

}
