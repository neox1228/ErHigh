package com.software.view;

import java.util.Scanner;

import com.software.entity.User;
import com.software.service.impl.UserServiceImpl;

public class RegisterView {
	public void register() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("========�û�ע��========");
		System.out.println("----------------");
		System.out.println("�û�����");
		String userName = scanner.next();
		System.out.println("----------------");
		System.out.println("��½���룺");
		String passWord = scanner.next();
		System.out.println("----------------");
		System.out.println("ѡ���Ա�1��Ů��0���У���");
		int sex = scanner.nextInt();
		System.out.println("----------------");
		System.out.println("���֤�ţ�");
		String idNumber = scanner.next();
		System.out.println("----------------");
		System.out.println("�绰���룺");
		String tel = " ";
		while(true) {
			tel = scanner.next();
			if (tel.length() != 11) {
				System.out.println("��ʽ�������������룺");
			}else {
				break;
			}
		}
		System.out.println("----------------");
		System.out.println("��ͥסַ��");
		String addr = scanner.next();
		System.out.println("----------------");
		User user = new User(0,userName, passWord, sex, idNumber, tel, addr,0);
		UserServiceImpl usi = new UserServiceImpl();
		int row = usi.register(user);
		StartView startView = new StartView();
		if (row > 0) {
			System.out.println("�û��������ڣ�ע��ɹ���");
			startView.start();
		}else {
			System.out.println("�û����Ѵ��ڣ�ע��ʧ�ܣ�");
			System.out.println("�Ƿ�����ע�᣿��Y or N��");
			String choose = scanner.next();
			if (choose.equals("y") || choose.equals("Y")) {
				register();
			}else {
				
			}
		}
	}

}
