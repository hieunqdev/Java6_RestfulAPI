package com.example.rest_api_demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_api_demo.model.SinhVien;

//Web Application: web được thiết kế kèm theo giao diện người dùng -> return url

//Web Service: web được thiết kế để kết nối với nhiều phần mềm khác. -> ko return url
//phần mềm khác: FE web web js gọi đến api -> hiển thị cho người dùng, 
//				mobile gọi đến api -> hiển thị cho người dùng.

//2 dạng chuẩn thiết kế API cho Web Service là REST API/RESTFULL API và SOAP.

//RESTFULL API có các phương thức:
//	GET: lấy dữ liệu
//	POST: create tạo dữ liệu
//	PUT: update cập nhật dữ liệu
//	DELETE: xóa dữ liệu


@RestController
public class SinhVienController {
	private List<SinhVien> users = new ArrayList<SinhVien>();
	
//	GET: lấy dữ liệu
	@GetMapping("/users")
	public List<SinhVien> getAll() {
		return users;
	}
	
//	POST: create tạo dữ liệu
	@PostMapping("/user")
	public SinhVien create(@RequestBody SinhVien sv) {
		users.add(sv);
		return sv;
	}
	
//	PUT: update cập nhật dữ liệu
	@PutMapping("/user")
	public void update(@RequestBody SinhVien sv) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == sv.getId()) {
				users.set(i, sv);
				break;
			}
		}
	}
	
//	DELETE: xóa dữ liệu
	@DeleteMapping("/user")
	public void delete(@RequestParam(name="id") int id) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == id) {
				users.remove(i);
				break;
			}
		}
	}

}
