package com.tranduylinh.ThymeleafNhaTro.entity;

public class HeThongNhaTro {
	private Long id;
	private String tenHeThong;
	private String diaChi;
	private Long soPhong;

	public HeThongNhaTro() {
		super();
	}

	public HeThongNhaTro(String tenHeThong, String diaChi, Long soPhong) {
		super();
		this.tenHeThong = tenHeThong;
		this.diaChi = diaChi;
		this.soPhong = soPhong;
	}

	public HeThongNhaTro(Long id, String tenHeThong, String diaChi, Long soPhong) {
		super();
		this.id = id;
		this.tenHeThong = tenHeThong;
		this.diaChi = diaChi;
		this.soPhong = soPhong;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTenHeThong() {
		return tenHeThong;
	}

	public void setTenHeThong(String tenHeThong) {
		this.tenHeThong = tenHeThong;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Long getSoPhong() {
		return soPhong;
	}

	public void setSoPhong(Long soPhong) {
		this.soPhong = soPhong;
	}

}
