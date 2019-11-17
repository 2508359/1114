package com.example.pintu1;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
public class MainActivity extends Activity{
 private ImageButton button00,button01,button02,button10,button11,button12,button20,button21,button22;
 private Button buttonrestart;
 private TextView textView;
 private int Imagex = 3;
 private int Imagey = 3;
 private int imgCount = Imagex * Imagey;
 private int length = imgCount;
 private int blankSwap = length - 1;
 private int blankImgid = R.id.btn_09;
 private int time;
 private boolean timeswitch = true;
//����һ��ͼƬ������±����飬��������������
 private int[] imageIndex = new int[length];
 private int[] image = { R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
		 R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
		 R.drawable.nine, };
 Handler handler = new Handler() {
   //Ϊ�˸���ʱ����handler���� 
  public void handleMessage(Message msg){
   if (msg.what == 1) {
    textView.setText("ʱ�䣺" + time);
    if (timeswitch){
     time++;
     handler.sendEmptyMessageDelayed(1,1000);
    }
   }
  };
 };
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  //��ʼ����Щ�ؼ�
  button00 = (ImageButton) findViewById(R.id.btn_01);
  button01 = (ImageButton) findViewById(R.id.btn_02);
  button02 = (ImageButton) findViewById(R.id.btn_03);
  button10 = (ImageButton) findViewById(R.id.btn_04);
  button11 = (ImageButton) findViewById(R.id.btn_05);
  button12 = (ImageButton) findViewById(R.id.btn_06);
  button20 = (ImageButton) findViewById(R.id.btn_07);
  button21 = (ImageButton) findViewById(R.id.btn_08);
  button22 = (ImageButton) findViewById(R.id.btn_09);
  textView = (TextView) findViewById(R.id.text_time);
  buttonrestart = (Button) findViewById(R.id.btn_restart);
  handler.sendEmptyMessageDelayed(1,1000);
  random();
 }
 
 private void random() {
  timeswitch = true;
  for (int i = 0; i < imageIndex.length; i++) {
	  // ����ѭ�����������ֵΪ012345678
   imageIndex[i] = i;
  }
  int rand1, rand2;
  for (int j = 0; j < 20; j++) {
	// math.random 0-1�������������8����0-8�������
   rand1 = (int) (Math.random() * (length - 1));
   do {
    rand2 = (int) (Math.random() * (length - 1));
    if (rand1 != rand2) {
     break;
    }
   } while (true);
   swap(rand1, rand2);
  }
//�������
  button00.setImageDrawable(getResources().getDrawable(image[imageIndex[0]]));
  button01.setImageDrawable(getResources().getDrawable(image[imageIndex[1]]));
  button02.setImageDrawable(getResources().getDrawable(image[imageIndex[2]]));
  button10.setImageDrawable(getResources().getDrawable(image[imageIndex[3]]));
  button11.setImageDrawable(getResources().getDrawable(image[imageIndex[4]]));
  button12.setImageDrawable(getResources().getDrawable(image[imageIndex[5]]));
  button20.setImageDrawable(getResources().getDrawable(image[imageIndex[6]]));
  button21.setImageDrawable(getResources().getDrawable(image[imageIndex[7]]));
  button22.setImageDrawable(getResources().getDrawable(image[imageIndex[8]]));
 }
 public void swap(int rand1, int rand2){
  int temp = imageIndex[rand1];
  imageIndex[rand1] = imageIndex[rand2];
  imageIndex[rand2] = temp;
 }
 public void onClick(View view) {
  
  int id = view.getId();
  
  switch (id) {
   case R.id.btn_01:
    move(R.id.btn_01, 0);
    break;
   case R.id.btn_02:
    move(R.id.btn_02, 1);
    break;
   case R.id.btn_03:
    move(R.id.btn_03, 2);
    break;
   case R.id.btn_04:
    move(R.id.btn_04, 3);
    break;
   case R.id.btn_05:
    move(R.id.btn_05, 4);
    break;
   case R.id.btn_06:
    move(R.id.btn_06, 5);
    break;
   case R.id.btn_07:
    move(R.id.btn_07, 6);
    break;
   case R.id.btn_08:
    move(R.id.btn_08, 7);
    break;
   case R.id.btn_09:
    move(R.id.btn_09, 8);
    break;
  }
 }
 //�����ͼƬ��հ�����Ľ����ķ���
 public void move(int imagbtnId, int site) {
  int sitex = site / Imagex;// site Ϊ�ڼ���ͼƬ
  int sitey = site % Imagey;
 //��ʼ���հ״�������
  int blankx = blankSwap / Imagex;
  int blanky = blankSwap % Imagey;
  
  int x = Math.abs(sitex - blankx);
  int y = Math.abs(sitey - blanky);
  
  if ( (x == 0 && y == 1) || (x == 1 && y == 0)) {
   //�����µ�imageButton���������Ǵ�������ͼƬ��ťid
   ImageButton clickButton = (ImageButton) findViewById(imagbtnId);
   clickButton.setVisibility(View.INVISIBLE);
   //����һ���µ�ͼƬ��ť��Ȼ��findviewbyid�հ׿ռ��id
   ImageButton blankButton = (ImageButton) findViewById(blankImgid);
   
   blankButton.setImageDrawable(getResources().getDrawable(image[imageIndex[site]]));
   //���ؼ�����Ϊ�ɼ�
   blankButton.setVisibility(View.VISIBLE);
   swap(site, blankSwap);
   //���µĿհ�����λ�ø��µ��ڴ������ĵ���İ�ť��λ��
   blankSwap = site;
   //���µĿհ�����id����Ϊ��������id
   blankImgid = imagbtnId;
  }
  gameOver();
 }

 public void restore() {
  handler.removeMessages(1);
  
  ImageButton clickButton = (ImageButton) findViewById(blankImgid);
  clickButton.setVisibility(View.VISIBLE);
  
  ImageButton blankButton = (ImageButton) findViewById(R.id.btn_09);
  
  blankButton.setVisibility(View.INVISIBLE);
  blankImgid = R.id.btn_09;
  blankSwap = length - 1;
 }
 //�ж�ƴͼ�Ƿ�ɹ�
 public void gameOver() {
  boolean loop = true;
  for (int i = 0; i < imageIndex.length; i++) {
   if (imageIndex[i] != i) {
    loop = false;
   }
  }
  if (loop) {
	// �ɹ���ʱ��ֹͣ
   timeswitch = false;
   // ���ƴͼ�ɹ�����ֹͼ��ť�ƶ�
   button00.setClickable(false);
   button01.setClickable(false);
   button02.setClickable(false);
   button10.setClickable(false);
   button11.setClickable(false);
   button12.setClickable(false);
   button20.setClickable(false);
   button21.setClickable(false);
   button22.setClickable(false);
   button22.setImageDrawable(getResources().getDrawable(image[8]));
   button22.setVisibility(View.VISIBLE);
   handler.removeMessages(1);
   AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
   builder.setMessage("��ϲ��ƴͼ�ɹ������õ�ʱ��Ϊ" + time + "��").setPositiveButton("ȷ��", null);
   AlertDialog dialog = builder.create();
   dialog.show();
  }
 }
 public void restart(View view) {
  time = 0;
  restore();
  textView.setText("ʱ�䣺" + time);
  timeswitch = true;
  handler.sendEmptyMessageDelayed(1,1000);
  button00.setClickable(true);
  button01.setClickable(true);
  button02.setClickable(true);
  button10.setClickable(true);
  button11.setClickable(true);
  button12.setClickable(true);
  button20.setClickable(true);
  button21.setClickable(true);
  button22.setClickable(true);
  random();
 }
}