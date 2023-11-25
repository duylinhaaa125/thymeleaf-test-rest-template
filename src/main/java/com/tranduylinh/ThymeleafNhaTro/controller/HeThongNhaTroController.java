package com.tranduylinh.ThymeleafNhaTro.controller;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;

import com.tranduylinh.ThymeleafNhaTro.entity.HeThongNhaTro;

@Controller
public class HeThongNhaTroController {

	static final String PathHeThongPhongTro = "http://localhost:8081/api/v1/HeThongNhaTro";
	static final String PathChiTietPhongTro = "http://localhost:8081/api/v1/ChiTietPhongTro";

	@GetMapping("/hethongnhatro")
	public String getAllHeThongNhaTro(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		HeThongNhaTro[] listHeThongNhaTro = restTemplate.getForObject(PathHeThongPhongTro, HeThongNhaTro[].class);
		model.addAttribute("listNhaTro", listHeThongNhaTro);
		return "hethongnhatro";
	}

	@GetMapping("/hethongnhatro/{id}")
	public String createHeThongNhaTro(Model model, @PathVariable Long id) {
		RestTemplate restTemplate = new RestTemplate();
		HeThongNhaTro[] heThongNhaTroById = restTemplate.getForObject(PathHeThongPhongTro + "/" + id,
				HeThongNhaTro[].class);
		model.addAttribute("nhatro", heThongNhaTroById);
		return "hethongnhatro";
	}

//	@GetMapping("/api/{id}")
//	String getPhongTroByID(@PathVariable Long id, Model model) {
//		RestTemplate restTemplate = new RestTemplate();
//		ChiTietPhongTro[] listAllChiTietPhongTro = restTemplate.getForObject(PathChiTietPhongTro,
//				ChiTietPhongTro[].class);
//		List<ChiTietPhongTro> listChiTietPhongTroByID = new ArrayList<ChiTietPhongTro>();
//		for (ChiTietPhongTro chiTiet : listAllChiTietPhongTro) {
//			if (chiTiet.getNhaTroId() == id) {
//				listChiTietPhongTroByID.add(chiTiet);
//			}
//		}
//		model.addAttribute("listPhongTroByID", listChiTietPhongTroByID);
//		return "chitietphongtro";
//	}

//	@PostMapping(value = "/hethongnhatro/insert")
//	public String saveHeThongNhaTro(Model model, @RequestBody HeThongNhaTro nhaMoi) {
//		String pathInsert = PathHeThongPhongTro + "/insert";
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<HeThongNhaTro> request = new HttpEntity<>(nhaMoi);
//		HeThongNhaTro heThongNhaTro = restTemplate.postForObject(pathInsert, request, HeThongNhaTro.class);
//		model.addAttribute("nhatro", heThongNhaTro);
//		return "insert_nhatro";
//	}

	@GetMapping("/hethongnhatro/new")
	public String createHeThongNhaTroForm(Model model) {
		// create student object to hold student form data
		HeThongNhaTro nhaTro = new HeThongNhaTro();
		model.addAttribute("nhaTro", nhaTro);
		return "insert_nhatro";
	}

	@PostMapping("/hethongnhatro")
	public String saveHeThongNhaTro(@ModelAttribute("nhaTro") HeThongNhaTro nhaTro) {
		String pathInsert = PathHeThongPhongTro + "/insert";
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<HeThongNhaTro> request = new HttpEntity<>(nhaTro);
		HeThongNhaTro heThongNhaTro = restTemplate.postForObject(pathInsert, request, HeThongNhaTro.class);
		return "redirect:/hethongnhatro";
	}

//	@PutMapping("/hethongnhatro/update/{id}")
//	public String updateHeThongNhaTro(@PathVariable Long id, Model model, @RequestBody HeThongNhaTro nhaMoi){
//		String pathUpdate = PathHeThongPhongTro + "/update/" + id;
//		HttpHeaders headers = new HttpHeaders();
//	    headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<HeThongNhaTro> requestBody = new HttpEntity<>(nhaMoi, headers);
//		ResponseEntity<HeThongNhaTro> heThongNhaTro = restTemplate.exchange(pathUpdate, HttpMethod.PUT ,requestBody, HeThongNhaTro.class);
//		model.addAttribute("nhatro", heThongNhaTro.getBody());
//		return "update_nhatro";
//	} 

	@GetMapping("/hethongnhatro/edit/{id}")
	public String editHeThongNhaTroForm(@PathVariable Long id, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		HeThongNhaTro heThongNhaTro = restTemplate.getForObject(PathHeThongPhongTro + "/" + id, HeThongNhaTro.class);

		model.addAttribute("nhatro", heThongNhaTro);
		return "update_nhatro";
	}

	@PutMapping("hethongnhatro/{id}")
	public String updateHeThongNhaTro(@PathVariable Long id, @ModelAttribute("nhatro") HeThongNhaTro nhaTro, Model model) {
		RestTemplate restTemplate = new RestTemplate();

		HttpEntity<HeThongNhaTro> request = new HttpEntity<>(nhaTro);

		ResponseEntity<HeThongNhaTro> heThongNhaTro = restTemplate.exchange(PathHeThongPhongTro + "/update/" + id,
				HttpMethod.PUT, request, HeThongNhaTro.class);
		return "redirect:/hethongnhatro";
	}

//	@DeleteMapping("/hethongnhatro/delete/{id}")
//	public String deleteHeThongNhaTro(@PathVariable Long id) {
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.delete(PathHeThongPhongTro + "/" + id);
//		return "redirect:/hethongnhatro";
//	}

	@GetMapping("hethongnhatro/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<HeThongNhaTro> requestBody = new HttpEntity<>(headers);
		ResponseEntity<HeThongNhaTro> heThongNhaTro = restTemplate.exchange(PathHeThongPhongTro + "/delete/" + id,
				HttpMethod.DELETE, requestBody, HeThongNhaTro.class);
		return "redirect:/hethongnhatro";

	}
}
