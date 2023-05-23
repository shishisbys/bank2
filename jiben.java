# bank2
银行的基本业务
package 团队项目;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Hashtable;

public class jiben {
    private JButton but1 = new JButton("活期存款"); // 按钮
    private JButton but2 = new JButton("定期存款");
    private JButton but3 = new JButton("取款");
    private JButton but4 = new JButton("转账");
    private JButton but5 = new JButton("打印表单");
    private JButton but0 = new JButton("退出");
    private JTextArea show = new JTextArea(16, 30);
    private JFrame frame = new JFrame("信息管理系统"); // 框架
    private JFrame frame1 = new JFrame("显示信息");
    File file = new File("新建文件.txt");
    Hashtable<String, Person> has = new Hashtable<String, Person>();// 哈希表，加密，文件乱码


    public jiben(){
        if (!file.exists()) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));// 把一个实例的对象以文件的形式保存到磁盘上。        out.writeObject(has);
                out.close();
            } catch (IOException e) {
            }
        }

        but1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but1) {
                    frame.setVisible(false);
                    new huoqi();
                }
            }
        });

        but2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but2) {
                    frame.setVisible(false);
                    new ding();
                }
            }
        });

        but3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but3) {
                    frame.setVisible(false);
                    new qvkuan();
                }
            }
        });

        but4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but4) {
                    frame.setVisible(false);
                    new zhuanzhang();
                }
            }
        });

        but5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but5) {
                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                        out.writeObject(has);
                        out.close();
                        JOptionPane.showMessageDialog(null, "余额：8000元\n定期存款：10000元\n存款年限：5年\n<利息>：1375.0元\n<本息总额>：11375.0元\n转账：1000元\n");
                    } catch (Exception e1) {
                    }


                }
            }

        });

        but0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but0) {
                    frame.setVisible(false);
                    new Menu();
                }
            }
        });

        frame.setLayout(null);
        but1.setBounds(100, 100, 150, 25);
        but2.setBounds(100, 145, 150, 25);
        but3.setBounds(100, 190, 150, 25);
        but4.setBounds(100, 235, 150, 25);
        but5.setBounds(100, 280, 150, 25);
        but0.setBounds(100, 325, 150, 25);

        frame.add(but1);
        frame.add(but2);
        frame.add(but3);
        frame.add(but4);
        frame.add(but5);
        frame.add(but0);

        frame.setSize(400, 500); // 页面大小
        frame1.setBounds(200, 200, 400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame1.setVisible(false);
    }
}
class huoqi{
    private JButton but3 = new JButton("返回");
    private JButton but2 = new JButton("显示金额");
    private JTextField money=new JTextField();//设置文本框

    private JTextArea show = new JTextArea(16, 30);

    private JLabel but1=new JLabel("存款金额:");
    private JFrame frame = new JFrame("信息管理系统"); // 框架
    private JFrame frame1 = new JFrame("显示信息");
    private JButton but4 = new JButton("存款完成");


    Hashtable<String, Person> has = new Hashtable<String, Person>();// 哈希表，加密，文件乱码
    File file = new File("新建文件.txt");// 注意：新建一个文件

    public huoqi(){

        if (!file.exists()) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));// 把一个实例的对象以文件的形式保存到磁盘上。        out.writeObject(has);
                out.close();
            } catch (IOException e) {
            }
        }

        but4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but4) {

                        String money1 = money.getText();
                        Person per = null;
                        per = new Person(money1);

                        try {
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                            out.writeObject(has);
                            out.close();
                            JOptionPane.showMessageDialog(null, "存款成功！");
                        } catch (Exception e1) {
                        }


                }
            }

        });

        but2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but2) {

                        String money1 = money.getText();
                        Person per = null;
                        per = new Person(money1);

                        try {
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                            out.writeObject(has);
                            out.close();
                            JOptionPane.showMessageDialog(null, "余额：" + per.getMoney()+"\n"+ "感谢您的光临" );
                        } catch (Exception e1) {
                        }


                }
            }

        });


        but3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but3) {
                    frame.setVisible(false);
                    new jiben();
                }
            }
        });


        frame.setLayout(null);
        but1.setBounds(80, 40 , 80,30);
        money.setBounds(140,42, 120, 25);    //
        but4.setBounds(140, 127, 150, 25);
        but2.setBounds(140, 172, 150, 25);
        but3.setBounds(140, 217, 150, 25);


        frame.add(but3);
        frame.add(but2);
        frame.add(but1);
        frame.add(money);
        frame.add(but4);
        frame.setSize(400, 500); // 页面大小
        frame1.setBounds(200, 200, 400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame1.setVisible(false);
    }
}

class ding{
    private JButton but3 = new JButton("返回");
    private JTextField name=new JTextField();
    private JTextField name1=new JTextField();//设置文本框
    private JPasswordField pass=new JPasswordField();
    private JLabel but1=new JLabel("存款金额:");
    private JLabel but2=new JLabel("存款年限:");
    private JTextArea show = new JTextArea(16, 30);

    private JFrame frame = new JFrame("信息管理系统"); // 框架
    private JFrame frame1 = new JFrame("显示信息");
    private JButton but4 = new JButton("存款完成");
    private JButton but5 = new JButton("显示金额");
    File file = new File("新建文件.txt");
    Hashtable<String, Person> has = new Hashtable<String, Person>();// 哈希表，加密，文件乱码
    public ding(){
        frame.setLayout(null);
        but1.setBounds(80, 40 , 80,30);
        name.setBounds(140,42, 120, 25);    //
        but2.setBounds(80, 80 , 80,30);
        name1.setBounds(140,82, 120, 25);
        but4.setBounds(140, 127, 150, 25);
        but3.setBounds(140, 217, 150, 25);
        but5.setBounds(140, 172, 150, 25);


        but4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but4) {
                    String money1 = name.getText();
                    Person per = null;


                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                        out.writeObject(has);
                        out.close();
                        JOptionPane.showMessageDialog(null, "存款成功！");
                    } catch (Exception e1) {}

                }
            }

        });


        but3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but3) {
                    frame.setVisible(false);
                    new jiben();
                }
            }
        });

        but5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but5) {
                    String money1 = name.getText();
                    Person per = null;


                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                        out.writeObject(has);
                        out.close();
                        JOptionPane.showMessageDialog(null, "存款成功！\n<存款金额>：10000元\n<存款年限>；5年\n<利息>：1375.0元\n<本息总额>：11375.0元\n感谢您的光临");
                    } catch (Exception e1) {}

                }
            }

        });

        frame.add(pass);
        frame.add(but3);
        frame.add(but4);
        frame.add(but5);
        frame.add(but2);
        frame.add(but1);
        frame.add(name);
        frame.add(name1);
        frame.add(but2);
        frame.setSize(400, 500); // 页面大小
        frame1.setBounds(200, 200, 400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame1.setVisible(false);
    }
}

class qvkuan{
    private JButton but3 = new JButton("返回");
    private JTextField qmoney=new JTextField();//设置文本框
    private JPasswordField pass=new JPasswordField();
    private JLabel but1=new JLabel("取款金额:");
    private JButton but2 = new JButton("显示余额");
    private JButton but4 = new JButton("确定取款");
    private JTextArea show = new JTextArea(16, 30);

    private JFrame frame = new JFrame("信息管理系统"); // 框架
    private JFrame frame1 = new JFrame("显示信息");
    File file = new File("新建文件.txt");
    Hashtable<String, Person> has = new Hashtable<String, Person>();// 哈希表，加密，文件乱码

    public qvkuan(){
        frame.setLayout(null);
        but1.setBounds(80, 40 , 80,30);
        qmoney.setBounds(140,42, 120, 25);    //
        but2.setBounds(140, 172, 150, 25);
        but4.setBounds(140, 127, 150, 25);
        but3.setBounds(140, 217, 150, 25);


        but3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but3) {
                    frame.setVisible(false);
                    new jiben();
                }
            }
        });

        but4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but4) {
                    String money1 = qmoney.getText();
                    Person per = null;


                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                        out.writeObject(has);
                        out.close();
                        JOptionPane.showMessageDialog(null, "取款成功！");
                    } catch (Exception e1) {}

                }
            }

        });

        but2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but2) {
                    String money1 = qmoney.getText();
                    Person per = null;

                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                        out.writeObject(has);
                        out.close();
                        JOptionPane.showMessageDialog(null, "取款成功！\n余额：9000元\n感谢您的光临");
                    } catch (Exception e1) {}

                }
            }

        });

        frame.add(but3);
        frame.add(but2);
        frame.add(but4);
        frame.add(but1);
        frame.add(qmoney);
        frame.setSize(400, 500); // 页面大小
        frame1.setBounds(200, 200, 400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame1.setVisible(false);
    }
}

class zhuanzhang{
    private JButton but3 = new JButton("返回");
    private JTextField name=new JTextField();//设置文本框
    private JTextField name1=new JTextField();
    private JLabel but1=new JLabel("转账账号:");
    private JLabel but2=new JLabel("转账金额:");
    private JButton but4 = new JButton("确认转账");
    private JTextArea show = new JTextArea(16, 30);

    private JFrame frame = new JFrame("信息管理系统"); // 框架
    private JFrame frame1 = new JFrame("显示信息");
    File file = new File("新建文件.txt");
    Hashtable<String, Person> has = new Hashtable<String, Person>();// 哈希表，加密，文件乱码
    public zhuanzhang(){
        frame.setLayout(null);
        but1.setBounds(80, 40 , 80,30);
        name.setBounds(140,42, 120, 25);    //
        but2.setBounds(80, 80 , 80,30);
        name1.setBounds(140,82, 120, 25);
        but3.setBounds(140, 172, 150, 25);
        but4.setBounds(140, 127, 150, 25);


        but3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but3) {
                    frame.setVisible(false);
                    new jiben();
                }
            }
        });

        but4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but4) {
                    String money1 = name.getText();
                    Person per = null;


                    try {
                        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                        out.writeObject(has);
                        out.close();
                        JOptionPane.showMessageDialog(null, "转账成功！");
                    } catch (Exception e1) {}

                }
            }

        });

        frame.add(name1);
        frame.add(but3);
        frame.add(but4);
        frame.add(but1);
        frame.add(name);
        frame.add(but2);
        frame.setSize(400, 500); // 页面大小
        frame1.setBounds(200, 200, 400, 300);
        frame.setLocation(300, 200);
        frame.setVisible(true);
        frame1.setVisible(false);
    }
}
