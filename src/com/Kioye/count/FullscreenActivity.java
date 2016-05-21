package com.Kioye.count;
import android.R.integer;
import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.text.Selection;
import android.text.Spannable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
public class FullscreenActivity extends Activity {
	public static int displayWidth;  //屏幕宽度
    public static int displayHeight; //屏幕高度
	public static double result;
	public static double front;
	public static double behind;
	public static Boolean ishistory;
	public static Boolean isdot;
	public static Boolean iscalculated; 
	public static String gettemp1;
	public static String gettemp2;
	public static char operator;
	public static String historyString;
	public static Boolean issound;
	public static LinearLayout fullLinearLayout;
	public static SoundPool soundPool;
	public static int clicksound;
	public static int errorsound;
	public static int congratulationsound;
	private CheckBox themeBox;
	private CheckBox soundBox;
	private TextView historyTextView;
	private ScrollView historyScrollView;
	private TextView tiptTextView;
	private TextView topTextView;
	private TextView middleTextView;
	private EditText bottomTextView;
	private Button nu1Button;
	private Button nu2Button;
	private Button nu3Button;
	private Button nu4Button;
	private Button nu5Button;
	private Button nu6Button;
	private Button nu7Button;
	private Button nu8Button;
	private Button nu9Button;
	private Button nu0Button;
	private Button nu00Button;
	private Button nunotButton;
	private Button operaddButton;
	private Button opercutButton;
	private Button operdivButton;
	private Button opermulButton;
	private Button operperButton;
	private Button operequalButton;
	private Button setButton;
	private Button oppoButton;
	private Button delButton;
	private Button acButton;
	private Button upButton;
	private Button downButton;
	private Button oButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        displayWidth = displayMetrics.widthPixels;
        displayHeight = displayMetrics.heightPixels;//---保存屏幕分辨率
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);
        iscalculated=false;isdot=false;ishistory=false;historyString="";issound=false;
        soundBox=(CheckBox) findViewById(R.id.checksound);
        themeBox=(CheckBox) findViewById(R.id.checktheme);
        historyScrollView=(ScrollView) findViewById(R.id.scrollviewhistory);
        historyTextView=(TextView) findViewById(R.id.texthistory);
        tiptTextView=(TextView) findViewById(R.id.textTip);
        topTextView=(TextView) findViewById(R.id.textShowtop);
        middleTextView=(TextView) findViewById(R.id.textShowmiddle);
        bottomTextView=(EditText) findViewById(R.id.textShowbottom);
        nu00Button=(Button) findViewById(R.id.butNum00);
        nu0Button=(Button) findViewById(R.id.butNum0);
        nunotButton=(Button) findViewById(R.id.butNumdot);
        nu1Button=(Button) findViewById(R.id.butNum1);
        nu2Button=(Button) findViewById(R.id.butNum2);
        nu3Button=(Button) findViewById(R.id.butNum3);
        nu4Button=(Button) findViewById(R.id.butNum4);
        nu5Button=(Button) findViewById(R.id.butNum5);
        nu6Button=(Button) findViewById(R.id.butNum6);
        nu7Button=(Button) findViewById(R.id.butNum7);
        nu8Button=(Button) findViewById(R.id.butNum8);
        nu9Button=(Button) findViewById(R.id.butNum9);
        operaddButton=(Button) findViewById(R.id.butOperAdd);
        opercutButton=(Button) findViewById(R.id.butOperCut);
        operdivButton=(Button) findViewById(R.id.butOperDiv);
        opermulButton=(Button) findViewById(R.id.butOperMul);
        operperButton=(Button) findViewById(R.id.butOperRma);
        operequalButton=(Button) findViewById(R.id.butOperOut);
        acButton=(Button) findViewById(R.id.butOperAC);
        delButton=(Button) findViewById(R.id.butOperDel);
        upButton=(Button) findViewById(R.id.butOperUp);
        downButton=(Button) findViewById(R.id.butOperDown);
        oButton=(Button) findViewById(R.id.butOperSpin);
        setButton=(Button) findViewById(R.id.butOperSet);
        oppoButton=(Button) findViewById(R.id.butOperOppo);
        fullLinearLayout=(LinearLayout) findViewById(R.id.linearlayoutfull);
        
        soundPool=new SoundPool(3, AudioManager.STREAM_SYSTEM, 5);
        clicksound=soundPool.load(getApplicationContext(), R.raw.click, 1);
        errorsound=soundPool.load(getApplicationContext(),R.raw.error ,3);
        congratulationsound=soundPool.load(getApplicationContext(), R.raw.congratulate, 2);
        
        nu00Button.setOnClickListener(new MyOnClickListener(){});
        nu0Button.setOnClickListener(new MyOnClickListener(){});
        nunotButton.setOnClickListener(new MyOnClickListener(){});
        nu1Button.setOnClickListener(new MyOnClickListener(){});
        nu2Button.setOnClickListener(new MyOnClickListener(){});
        nu3Button.setOnClickListener(new MyOnClickListener(){});
        nu4Button.setOnClickListener(new MyOnClickListener(){});
        nu5Button.setOnClickListener(new MyOnClickListener(){});
        nu6Button.setOnClickListener(new MyOnClickListener(){});
        nu7Button.setOnClickListener(new MyOnClickListener(){});
        nu8Button.setOnClickListener(new MyOnClickListener(){});
        nu9Button.setOnClickListener(new MyOnClickListener(){});
        operaddButton.setOnClickListener(new MyOnClickListener(){});
        opercutButton.setOnClickListener(new MyOnClickListener(){});
        operdivButton.setOnClickListener(new MyOnClickListener(){});
        opermulButton.setOnClickListener(new MyOnClickListener(){});
        operperButton.setOnClickListener(new MyOnClickListener(){});
        operequalButton.setOnClickListener(new MyOnClickListener(){});
        acButton.setOnClickListener(new MyOnClickListener(){});
        delButton.setOnClickListener(new MyOnClickListener(){});
        upButton.setOnClickListener(new MyOnClickListener(){});
        downButton.setOnClickListener(new MyOnClickListener(){});
        oButton.setOnClickListener(new MyOnClickListener(){});
        setButton.setOnClickListener(new MyOnClickListener(){});
        oppoButton.setOnClickListener(new MyOnClickListener(){});
        setButton.setOnLongClickListener(new OnLongClickListener() {
			@Override
			public boolean onLongClick(View arg0) {
				if (themeBox.getAlpha()!=1) {
				tiptTextView.setText("Your potential is a shock.");
				{//Toast 带图片的提示框
				Toast toast=Toast.makeText(getApplicationContext(), "\n \n You get the VIP privilege! ", Toast.LENGTH_LONG); 
				toast.setGravity(Gravity.CENTER, 0, 0); 
				//创建图片视图对象 
				ImageView imageView= new ImageView(getApplicationContext()); 
				//设置图片 
				imageView.setImageResource(R.drawable.congratulate); 
				//获得toast的布局 
				LinearLayout toastView = (LinearLayout) toast.getView(); 
				//设置此布局为横向的 
				toastView.setOrientation(LinearLayout.HORIZONTAL); 
				//将ImageView在加入到此布局中的第一个位置 
				toastView.addView(imageView, 0); 
				toast.show(); }
				if (issound==true) {
					soundPool.play(congratulationsound, 1,1, 2, 0, 1);
				}else Toast.makeText(getApplicationContext(), "VIP has been opened!", Toast.LENGTH_SHORT).show();
				themeBox.setAlpha(1f);themeBox.setEnabled(true);
				}
				return true;
			}
		});
        soundBox.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (issound==true) {
					soundPool.play(clicksound, 1,1, 1, 0, 1);
				}
				if (soundBox.isChecked()==true) {
					issound=true;
				}else {
					issound=false;
				}
			}
		});
        themeBox.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if (themeBox.isChecked()==true) {
				fullLinearLayout.setBackgroundResource(R.drawable.background);
				bottomTextView.setBackgroundResource(R.drawable.editbackgroundlow);
				bottomTextView.setTextColor(0xffffffff);
				topTextView.setBackgroundResource(R.drawable.editbackgroundlow);
				topTextView.setTextColor(0xffffffff);
				middleTextView.setBackgroundResource(R.drawable.editbackgroundlow);
				middleTextView.setTextColor(0xffffffff);
				//------Buttom
				nu00Button.setBackgroundResource(R.drawable.numselect2);
				nu0Button.setBackgroundResource(R.drawable.numselect2);
				nu1Button.setBackgroundResource(R.drawable.numselect2);
				nu2Button.setBackgroundResource(R.drawable.numselect2);
				nu3Button.setBackgroundResource(R.drawable.numselect2);
				nu4Button.setBackgroundResource(R.drawable.numselect2);
				nu5Button.setBackgroundResource(R.drawable.numselect2);
				nu6Button.setBackgroundResource(R.drawable.numselect2);
				nu7Button.setBackgroundResource(R.drawable.numselect2);
				nu8Button.setBackgroundResource(R.drawable.numselect2);
				nu9Button.setBackgroundResource(R.drawable.numselect2);
				nunotButton.setBackgroundResource(R.drawable.numselect2);
				operaddButton.setBackgroundResource(R.drawable.operselect2);
				opercutButton.setBackgroundResource(R.drawable.operselect2);
				operdivButton.setBackgroundResource(R.drawable.operselect2);
				opermulButton.setBackgroundResource(R.drawable.operselect2);
				operperButton.setBackgroundResource(R.drawable.operselect2);
				oppoButton.setBackgroundResource(R.drawable.opposelect2);
				acButton.setBackgroundResource(R.drawable.acselect2);
				upButton.setBackgroundResource(R.drawable.dafuselect2);
				downButton.setBackgroundResource(R.drawable.dafuselect2);
				delButton.setBackgroundResource(R.drawable.delselect2);
				setButton.setBackgroundResource(R.drawable.setselect2);
				oButton.setBackgroundResource(R.drawable.spinselect2);
				operequalButton.setBackgroundResource(R.drawable.equselect2);
				
				}else {
					fullLinearLayout.setBackgroundColor(0xfff9f9f9);
					bottomTextView.setBackgroundResource(R.drawable.topshow);
					bottomTextView.setTextColor(0xff341434);
					topTextView.setBackgroundResource(R.drawable.topshow);
					topTextView.setTextColor(0xff555555);
					middleTextView.setBackgroundResource(R.drawable.topshow);
					middleTextView.setTextColor(0xff788778);
					//Buttom
					nu00Button.setBackgroundResource(R.drawable.numselect);
					nu0Button.setBackgroundResource(R.drawable.numselect);
					nu1Button.setBackgroundResource(R.drawable.numselect);
					nu2Button.setBackgroundResource(R.drawable.numselect);
					nu3Button.setBackgroundResource(R.drawable.numselect);
					nu4Button.setBackgroundResource(R.drawable.numselect);
					nu5Button.setBackgroundResource(R.drawable.numselect);
					nu6Button.setBackgroundResource(R.drawable.numselect);
					nu7Button.setBackgroundResource(R.drawable.numselect);
					nu8Button.setBackgroundResource(R.drawable.numselect);
					nu9Button.setBackgroundResource(R.drawable.numselect);
					nunotButton.setBackgroundResource(R.drawable.numselect);
					operaddButton.setBackgroundResource(R.drawable.operselect);
					opercutButton.setBackgroundResource(R.drawable.operselect);
					operdivButton.setBackgroundResource(R.drawable.operselect);
					opermulButton.setBackgroundResource(R.drawable.operselect);
					operperButton.setBackgroundResource(R.drawable.operselect);
					oppoButton.setBackgroundResource(R.drawable.opposelect);
					acButton.setBackgroundResource(R.drawable.acselect);
					upButton.setBackgroundResource(R.drawable.dafuselect);
					downButton.setBackgroundResource(R.drawable.dafuselect);
					delButton.setBackgroundResource(R.drawable.delselect);
					setButton.setBackgroundResource(R.drawable.setselect);
					oButton.setBackgroundResource(R.drawable.spinselect);
					operequalButton.setBackgroundResource(R.drawable.equselect);
				}
			}
		});
        }
    
    
    class MyOnClickListener implements OnClickListener{
    	
    		public Boolean caculateResult(){
    			if (gettemp1.length()==1&&gettemp1.charAt(0)=='.') {
    				Toast.makeText(getApplicationContext(), "The number only has '.' is wrong!", Toast.LENGTH_SHORT).show();
        			return false;
				}
    			if(gettemp2!=null&&gettemp2.length()!=0&&operator!='!'){
    				if(gettemp1.length()!=0&&gettemp1!=null){
    					topTextView.setText(gettemp2);
    					middleTextView.setText(gettemp1);
    					front=Double.parseDouble(gettemp2);
    					behind=Double.parseDouble(gettemp1);
    					result=0;
    					switch (operator) {
						case '+':
							result=front+behind;
							break;
						case '—':
							result=front-behind;
							break;
						case '×':
							result=front*behind;
							break;
						case '÷':
							if (behind!=0) {
								result=front/behind;
							}else {
								if (issound==true) {
									soundPool.play(errorsound, 1,1, 3, 0, 1);
								}
								Toast.makeText(getApplicationContext(), "The dividend is wrong!", Toast.LENGTH_SHORT).show();
								result=-1;}
							break;
						case '%':
							result=front%behind;
							break;
						default:
							if (issound==true) {
								soundPool.play(errorsound, 1,1, 3, 0, 1);
							}
							Toast.makeText(getApplicationContext(), "Operator error!", Toast.LENGTH_SHORT).show();
							break;
						}
    					operator='!';
    					int resultint=(int) result;
    					if ((result-resultint)==0) {
    						bottomTextView.setText(resultint+"");
						}else bottomTextView.setText(result+"");
    					
    					gettemp1=bottomTextView.getText().toString();
    					gettemp2=middleTextView.getText().toString();
    					iscalculated=true;isdot=false;
    					return true;
    				}else {if (issound==true) {
    					soundPool.play(errorsound, 1,1, 3, 0, 1);}
    				Toast.makeText(getApplicationContext(), "Pelase type the dividend!", Toast.LENGTH_SHORT).show();return false;}}
    			operator='!';
    			return false;
    		}
		@Override
		public void onClick(View v) {
			if (issound==true) {
				soundPool.play(clicksound, 1,1, 1, 0, 1);
			}
			gettemp1=bottomTextView.getText().toString();
			gettemp2=middleTextView.getText().toString();
			switch (v.getId()) {
case R.id.butNum00:
case R.id.butNum0:
case R.id.butNumdot:
case R.id.butNum1:
case R.id.butNum2:
case R.id.butNum3:
case R.id.butNum4:
case R.id.butNum5:
case R.id.butNum6:
case R.id.butNum7:
case R.id.butNum8:
case R.id.butNum9:
	if(iscalculated==true){gettemp1="";iscalculated=false;}
	gettemp1 +=((Button)v).getText();
	for (int didwether0=0;didwether0<2;didwether0++) {
	if (gettemp1.length()>1) {
		if (gettemp1.length()>2) {
			if (gettemp1.charAt(0)=='-'&&gettemp1.charAt(1)=='0'&&gettemp1.charAt(2)=='0') {
				gettemp1="-"+gettemp1.substring(2, gettemp1.length());
			}
		}
		if (gettemp1.charAt(0)=='0'&&gettemp1.charAt(1)=='0') {
			gettemp1=gettemp1.substring(1, gettemp1.length());
		}
	}
	}
	if (gettemp1.charAt(gettemp1.length()-1)=='.') {
		if (isdot==true) {
			gettemp1=gettemp1.substring(0, gettemp1.length()-1);
			if (issound==true) {
				soundPool.play(errorsound, 1,1, 3, 0, 1);
			}
			Toast.makeText(getApplicationContext(), "Piont is overlimit", Toast.LENGTH_SHORT).show();
		}else {
			isdot=true;
		}
	}
	
	bottomTextView.setText(gettemp1);
	break;
case R.id.butOperAC:
	operator='!';
	isdot=false;
	iscalculated=false;
	bottomTextView.setText("");
	middleTextView.setText("");
	topTextView.setText("");
	break;
case R.id.butOperAdd:
case R.id.butOperCut:
case R.id.butOperMul:
case R.id.butOperDiv:
case R.id.butOperRma:
	if (caculateResult()==true||(gettemp1.length()!=0&&gettemp1!=null&&gettemp1.charAt(0)!='.')) {
		if(topTextView.getText()!=null&&topTextView.getText().length()!=0){
			historyString+=('\n'+topTextView.getText().toString());}
		topTextView.setText(middleTextView.getText());
		middleTextView.setText(bottomTextView.getText());
		bottomTextView.setText("");
		isdot=false;
	}else if(gettemp2!=null&&gettemp2.length()!=0){
		Toast.makeText(getApplicationContext(), "Pelase type the dividend!", Toast.LENGTH_SHORT).show();
	}else {
		Toast.makeText(getApplicationContext(), "Content is empty!", Toast.LENGTH_SHORT).show();
	}
	operator=((Button)v).getText().charAt(0);
	iscalculated=false;
	break;

case R.id.butOperDel:
	if (gettemp1.length()!=0) {
		if (isdot==true&&gettemp1.charAt(gettemp1.length()-1)=='.') {
			isdot=false;
		}
		bottomTextView.setText(gettemp1.substring(0, gettemp1.length()-1));
	}else {
		Toast.makeText(getApplicationContext(), "No number!", Toast.LENGTH_SHORT).show();
	}
	break;
case R.id.butOperOppo:
	if (gettemp1.length()>0&&gettemp1.charAt(0)=='-') {
		gettemp1=gettemp1.substring(1,gettemp1.length());
	}else {
		gettemp1="-"+gettemp1;
	}
	bottomTextView.setText(gettemp1);
	break;
case R.id.butOperDown:
	tiptTextView.setText("Being developed...");
	break;
case R.id.butOperOut:
	if(caculateResult()==true)
	tiptTextView.setText("Successful calculation!");
	break;
case R.id.butOperSet:
	FrameLayout.LayoutParams params = null;
	if (ishistory==false){
		ishistory=true;
		Toast.makeText(getApplicationContext(), "Historical data loading...", Toast.LENGTH_SHORT).show();
		historyTextView.setText(historyString);
		params = new FrameLayout.LayoutParams((int) (displayWidth*0.4),(int) (displayHeight * 1));
	}else {
		ishistory=false;
		Toast.makeText(getApplicationContext(), "Closed historical data.", Toast.LENGTH_SHORT).show();
		params = new FrameLayout.LayoutParams((int) (displayWidth*0.4),(int) (displayHeight * 0));
	}
    historyScrollView.setLayoutParams(params);
	break;
case R.id.butOperSpin:
	tiptTextView.setText("D1:"+gettemp1+" D2:"+gettemp2);
	break;
case R.id.butOperUp:
	tiptTextView.setText("Being developed...");
	break;

			default:
				Toast.makeText(getApplicationContext(), "The button is not defined!", Toast.LENGTH_SHORT).show();
				break;
			}
			if (bottomTextView.getText().length()!=0) {
				
			}//将光标移到最后
			CharSequence text = bottomTextView.getText();
			//Debug.asserts(text instanceof Spannable);
			if (text instanceof Spannable) {
			    Spannable spanText = (Spannable)text;
			   Selection.setSelection(spanText, text.length());
			}
		}
		
    }
}



