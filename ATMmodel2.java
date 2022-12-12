import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.*;
/***********主类*****************/
public class ATMmodel {
    Account myaccount=new Account();//账户实例化
    Load load=new Load();
    MainFrame Jmain=new MainFrame();//主框架实例化
    Take take=new Take();
    Input input=new Input();
    Display dis=new Display();
    Setpw setpw=new Setpw();//设置密码实例化
    /************ 主方法******************/
    public ATMmodel() {
        JOptionPane.showMessageDialog(null,"欢迎使用ATM柜员模拟系统！");//进入主界面时用JOptionPane.showMessageDialog（）；弹出系统提示
    }
    public static void main(String[] args) {
        ATMmodel atm=new ATMmodel();//主函数实例化
    }
    /**************创建账户**********/
    class Account {
        private int count=10000;            //初始账户余额10000
        private String account="123456";    //初始账号
        private String password="123456";   //初始密码
        public Account() {    //账户函数
        }
        public void setpw(String password){     //设置密码
            this.password=password;
        }
        public void deccount(int money){      //deccount 取款
            count-=money;//取款后再原来基础上减所取部分
        }
        public void reccount(int money){     //reccount 存款
            count+=money;//存款后在原来基础上加所存部分
        }
        public int get(){
            return count;//获取余额
        }
        public String getaccount(){
            return account;//获取账号
        }
        public String getpw(){
            return password;//获取密码
        }

    }
    /*********************主界面************************/
    class MainFrame extends JFrame {  //主框架方法由JFrame继承而来
        public JButton checked;  //检测
        public JButton cunkuan;  //存款
        public JButton quit;     //退出
        public JButton qukuan;   //取款
        public JButton reset;   //重设
        //框架按钮参数
        public MainFrame() {   //主框架函数
            initComponents();  //添加组件
            this.setLocationRelativeTo(null); //设置窗口相对于指定组件的位置
            this.setVisible(false); //隐藏其他窗口
        }
        /* 控件初始化*/
        private void initComponents() {    //初始化添加组件的和添加监听器
            cunkuan = new JButton();
            qukuan = new JButton();
            checked = new JButton();
            reset = new JButton();
            quit = new JButton();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//退出程序
            setTitle("ATM柜员模拟程序");
            setName("mianframe");//设置名称
            setResizable(false);        //窗口大小不可改变
            cunkuan.setText("存款");   //将“cunkuan”转换成“存款”
            cunkuan.addActionListener(new ActionListener() {     //设置事件监听
                public void actionPerformed(ActionEvent evt) {   //活动事件响应
                    cunkuanActionPerformed(evt);
                }
            });
            qukuan.setText("取款");
            qukuan.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    qukuanActionPerformed(evt);
                }
            });
            checked.setText("查询");
            checked.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    checkedActionPerformed(evt);
                }
            });
            reset.setText("修改密码");
            reset.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    resetActionPerformed(evt);
                }
            });
            quit.setText("退出");
            quit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    quitActionPerformed(evt);
                }
            });
            //程序界面划分，界面布局 //
            GroupLayout layout = new GroupLayout(getContentPane());    //GroupLayout它将组件按层次分组，以决定它们在 Container 中的位置
            getContentPane().setLayout(layout);//内容面板
            layout.setHorizontalGroup(            //水平划分
                    layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(cunkuan)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                                                    .addComponent(reset))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(qukuan)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                                                    .addComponent(quit))
                                            .addComponent(checked))
                                    .addContainerGap())
            );
            layout.setVerticalGroup(  //垂直划分
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cunkuan)
                                            .addComponent(reset))
                                    .addGap(51, 51, 51)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(quit)
                                            .addComponent(qukuan))
                                    .addGap(57, 57, 57)
                                    .addComponent(checked)
                                    .addGap(39, 39, 39))
            );
            pack();//使此 JFrame 的子组件按其首选大小进行布局
        }
        private void quitActionPerformed(ActionEvent evt) {  //识别是否退出
            load.setVisible(true);
            this.setVisible(false);
        }
        private void resetActionPerformed(ActionEvent evt) {  //识别是否修改
            setpw.setVisible(true);
            this.setVisible(false);
        }
        private void checkedActionPerformed(ActionEvent evt) {  //识别是否查询
            dis.setVisible(true);
            this.setVisible(false);
        }
        private void qukuanActionPerformed(ActionEvent evt) {  //识别是否取款
            take.setVisible(true);
            this.setVisible(false);
        }
        private void cunkuanActionPerformed(ActionEvent evt) {  //识别是否存款
            input.setVisible(true);
            this.setVisible(false);
        }
    }
    /********登录界面********/
    class Load extends JFrame{
        public JPasswordField Jpassword;
        public JTextField accountnum;//
        public JButton commit;//增删
        private JLabel jL1;//设置对齐
        private JLabel jL2;
        public Load() {
            initComponents();  //初始化添加组件的和添加监听器
            this.setLocationRelativeTo(null);//使窗口至于屏幕中央
            this.setVisible(true);
        }
        private void initComponents() {
            jL1 = new JLabel();  //对齐方法
            jL2 = new JLabel();
            accountnum = new JTextField();//允许编辑单行文本
            commit = new JButton();
            Jpassword = new JPasswordField();//单独提供它可以较方便地安全更改 JTextField 的 UI 而不影响密码输入
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setTitle("ATM柜员模拟程序");  //设置标题
            setResizable(false);//窗口大小不可改变
            jL1.setText("账号:");
            jL2.setText("密码:");
            commit.setText("确定");
            commit.addActionListener(new java.awt.event.ActionListener() {    //设置事件监听
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    commitActionPerformed(evt);
                }
            });
            /**********界面登陆设计**********/
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);//获取组件窗格
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addContainerGap(50, Short.MAX_VALUE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jL1)//添加组件jL1
                                                            .addComponent(jL2))
                                                    .addGap(31, 31, 31)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(Jpassword)
                                                            .addComponent(accountnum, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(122, 122, 122)
                                                    .addComponent(commit)))
                                    .addContainerGap(72, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(accountnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jL1))
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jL2)
                                            .addComponent(Jpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                                    .addComponent(commit)
                                    .addGap(64, 64, 64))
            );
            pack();
        }
        private void commitActionPerformed(ActionEvent evt) {
            if(accountnum.getText().equals(myaccount.getaccount()) && Jpassword.getText().equals(myaccount.getpw()))//识别密码是否与初始密码一致
            {
                Jmain.setVisible(true);
                this.setVisible(false);
                accountnum.setText("");
                Jpassword.setText("");
            }
            else{
                JOptionPane.showMessageDialog(null,"密码与账户不匹配,请重新输入","出错提示",1);//密码不正确的提示
                accountnum.setText("");
                Jpassword.setText("");
            }
        }
    }
    /*******取款界面********/
    class Take extends JFrame {
        public JButton back;
        public JButton clear;
        public JButton commit;
        private JLabel jL1;
        public JTextField jT1;
        public JButton quit;
        String str="";
        public Take() {
            initComponents();
            this.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        private void initComponents() {
            jL1 = new JLabel();
            jT1 = new JTextField();
            commit = new JButton();
            back = new JButton();
            quit = new JButton();
            clear = new JButton();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jL1.setText("取款金额:");
            commit.setText("确定");
            commit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    commitActionPerformed(evt);
                }
            });
            back.setText("返回");
            back.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    backActionPerformed(evt);
                }
            });
            quit.setText("退出");
            quit.addActionListener(new ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    quitActionPerformed(evt);
                }
            });
            clear.setText("清除");
            clear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    clearActionPerformed(evt);
                }
            });
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jL1)
                                                    .addGap(33, 33, 33)
                                                    .addComponent(jT1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(clear)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                                                    .addComponent(quit))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(commit)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                                                    .addComponent(back)))
                                    .addContainerGap(69, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(103, 103, 103)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jL1)
                                            .addComponent(jT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(61, 61, 61)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(commit)
                                            .addComponent(back))
                                    .addGap(29, 29, 29)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(clear)
                                            .addComponent(quit))
                                    .addContainerGap(65, Short.MAX_VALUE))
            );
            pack();
        }
        private void clearActionPerformed(ActionEvent evt) {
            str="";
            jT1.setText(str);
        }
        private void quitActionPerformed(ActionEvent evt) {
            load.setVisible(true);
            this.setVisible(false);
        }
        private void backActionPerformed(ActionEvent evt) {
            Jmain.setVisible(true);
            this.setVisible(false);
        }

        private void commitActionPerformed(ActionEvent evt) {

            if(Integer.parseInt(jT1.getText())>0 && Integer.parseInt(jT1.getText())%100==0 && Integer.parseInt(jT1.getText())<=5000){  //取款数必须为100的整数且不可超过5000
                myaccount.deccount(Integer.parseInt(jT1.getText()));
                int result=javax.swing.JOptionPane.showConfirmDialog(null,"是否显示余额？","",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);
                if(result==javax.swing.JOptionPane.YES_OPTION)
                {
                    dis.set(String.valueOf(myaccount.get()));
                    str="";
                    jT1.setText(str);
                    dis.setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    Jmain.setVisible(true);
                    this.setVisible(false);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"取款金额不能为负数"+"\n取款金额不能为0"+"\n取款金额必须是100的倍数"+
                        "\n金额一次不能超过5000"+"\n请重新输入你要取的金额数","出错提示",1);//如果多次输错的提示
                str="";
                jT1.setText(str);
            }
        }
    }
    /***********存款界面*********/
    class Input extends JFrame {
        private JButton clear;
        private JButton commit;
        private JLabel jL1;
        private JTextField jT1;
        String str="";
        public Input() {
            initComponents();
            this.setLocationRelativeTo(null);
            this.setResizable(false);
            this.setVisible(false);
        }
        private void initComponents() {
            jL1 = new JLabel();
            jT1 = new JTextField();
            commit = new JButton();
            clear = new JButton();      setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jL1.setText("存款金额:");
            commit.setText("确认");
            commit.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    commitActionPerformed(evt);
                }
            });
            clear.setText("清除");
            clear.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    clearActionPerformed(evt);
                }
            });
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addGap(12, 12, 12)
                                                    .addComponent(commit)
                                                    .addGap(111, 111, 111)
                                                    .addComponent(clear))
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jL1)
                                                    .addGap(27, 27, 27)
                                                    .addComponent(jT1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addContainerGap(50, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(88, 88, 88)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jL1)
                                            .addComponent(jT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(87, 87, 87)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(clear)
                                            .addComponent(commit))
                                    .addContainerGap(88, Short.MAX_VALUE))
            );
            pack();
        }// </editor-fold>

        private void clearActionPerformed(ActionEvent evt) {
            str="";
            jT1.setText(str);
        }

        private void commitActionPerformed(java.awt.event.ActionEvent evt) {
            if(Integer.parseInt(jT1.getText())%100==0)
            {
                int a=Integer.parseInt(jT1.getText());
                if(a<0)
                    JOptionPane.showMessageDialog(null,"存款不能为负数","出错",1);
                else
                    myaccount.reccount(a);
                dis.set(String.valueOf(myaccount.get()));
                int result=javax.swing.JOptionPane.showConfirmDialog(null,"是否显示余额？","",javax.swing.JOptionPane.YES_NO_OPTION,javax.swing.JOptionPane.QUESTION_MESSAGE);

                if(result==javax.swing.JOptionPane.YES_OPTION)
                {

                    str="";
                    jT1.setText(str);
                    dis.setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    Jmain.setVisible(true);
                    this.setVisible(false);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,"存款金额必须为100的整数倍!"+"\n请确认你的金额","出错提示",1);
                jT1.setText("");
            }
        }
    }
    /**********显示余额界面**********/
    class Display extends JFrame {
        public JButton back;
        private JLabel jL1;
        public JTextField jT1;
        public JButton quit;
        public JButton qukuan;
        public Display() {
            initComponents();
            jT1.setText(String.valueOf(myaccount.get()));
            this.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        public void set(String str){
            jT1.setText(str);
        }
        private void initComponents() {
            jL1 = new JLabel();
            jT1 = new JTextField();
            quit = new JButton();
            back = new JButton();
            qukuan = new JButton();
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jL1.setText("您的余额为:");
            jT1.setEditable(false);
            quit.setText("退出");
            quit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    quitActionPerformed(evt);
                }
            });
            back.setText("返回");
            back.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    backActionPerformed(evt);
                }
            });
            qukuan.setText("取款");
            qukuan.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    qukuanActionPerformed(evt);
                }
            });
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(jL1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jT1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(36, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addContainerGap(215, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(back)
                                            .addComponent(qukuan)
                                            .addComponent(quit))
                                    .addContainerGap())
            );    layout.setVerticalGroup(         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                            .addGap(93, 93, 93)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jL1)
                                    .addComponent(jT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(54, 54, 54)
                            .addComponent(qukuan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(back)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(quit)
                            .addContainerGap())
            );
            pack();
        }
        private void qukuanActionPerformed(ActionEvent evt) {
            take.setVisible(true);
            this.setVisible(false);
        }
        private void quitActionPerformed(ActionEvent evt) {
            load.setVisible(true);
            this.setVisible(false);
        }
        private void backActionPerformed(ActionEvent evt) {
            Jmain.setVisible(true);
            this.setVisible(false);
        }
    }
    /*************修改密码 ********/
    class Setpw extends JFrame {
        public JButton commit;
        public JLabel commitpw;
        public JPasswordField jPwcommit;
        public JPasswordField jPwnew;
        public JPasswordField jPwold;
        public JLabel newpw;
        public JLabel oldpw;
        public JButton quit;
        public Setpw() {
            initComponents();
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            //this.setVisible(false);
        }
        private void initComponents() {
            oldpw = new JLabel();
            newpw = new JLabel();
            commitpw = new JLabel();
            jPwold = new JPasswordField();
            jPwnew = new JPasswordField();
            jPwcommit = new JPasswordField();
            commit = new javax.swing.JButton();
            quit = new javax.swing.JButton();
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            oldpw.setText("旧密码:");
            newpw.setText("新密码:");
            commitpw.setText("确认密码:");
            commit.setText("确认");
            commit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    commitActionPerformed(evt);
                }
            });
            quit.setText("退出");
            quit.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    quitActionPerformed(evt);
                }
            });
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(oldpw)
                                            .addComponent(newpw)
                                            .addComponent(commitpw))
                                    .addGap(25, 25, 25)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addComponent(commit)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(quit))
                                            .addComponent(jPwnew, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                            .addComponent(jPwold)
                                            .addComponent(jPwcommit))
                                    .addContainerGap(48, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(53, 53, 53)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(oldpw)
                                            .addComponent(jPwold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(36, 36, 36)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(newpw)
                                            .addComponent(jPwnew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(40, 40, 40)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(commitpw)
                                            .addComponent(jPwcommit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(commit)
                                            .addComponent(quit))
                                    .addGap(36, 36, 36)) );
            pack();
        }
        private void commitActionPerformed(ActionEvent evt) {
            boolean flag=false;//标志密码不能出现全部相同的数字
            if(!jPwold.getText().equals(myaccount.getpw()))
            {
                JOptionPane.showMessageDialog(null,"你输入的密码与老密码不匹配!","错误提示",1);//1是符号    二是标题
            }
            else if(jPwnew.getText().length()<6)
                JOptionPane.showMessageDialog(null,"新密码长度必须大于或等于6位","错误提示",1);
            else{
                //用一个循环来查询密码是否全部一样
                for(int i=0;i<jPwnew.getText().length();i++)
                {
                    if(jPwnew.getText().charAt(0)==jPwnew.getText().charAt(i))
                        flag=true;
                    else{
                        flag=false;
                        break;
                    }

                }
                //密码全部一样则给出提示
                if(flag)	JOptionPane.showMessageDialog(null,"密码不能全都相同","错误提示",1);
                    //以上情况都没出现则修改成功
                else if(jPwold.getText().equals(myaccount.getpw()) && jPwnew.getText().equals(jPwcommit.getText()))
                {	myaccount.setpw(jPwnew.getText());		JOptionPane.showMessageDialog(null,"密码修改成功,请记住你的新密码","",1);
                    Jmain.setVisible(true);
                    this.setVisible(false);
                }
            }
        }
        private void quitActionPerformed(java.awt.event.ActionEvent evt) {
            load.setVisible(true);
            this.setVisible(false);
        }
    }
}