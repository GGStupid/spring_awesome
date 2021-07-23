package com.example.spring_awesome.mbg.model;

import java.io.Serializable;

/**
 * @Description:
 * @author:PmsBrand
 * @date: 2021/7/23 14:46
 */
public class PmsBrand implements Serializable {
    private Long id;
    private String name;
    private String firstLetter;
    private Integer sort;

	/**
	 * 是否为品牌制造商：0->不是；1->是
	 *
	 * @mbggenerated
	 */
	private Integer factoryStatus;

	private Integer showStatus;
	/**
	 * 产品数量
	 *
	 * @mbggenerated
	 */
	private Integer productCount;

	/**
	 * 产品评论数量
	 *
	 * @mbggenerated
	 */
	private Integer productCommentCount;

	/**
	 * 品牌logo
	 *
	 * @mbggenerated
	 */
	private String logo;

	/**
	 * 专区大图
	 *
	 * @mbggenerated
	 */
	private String bigPic;

	/**
	 * 品牌故事
	 *
	 * @mbggenerated
	 */
	private String brandStory;
	private static final long serialVersionUID = 1L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstLetter() {
		return firstLetter;
	}

	public void setFirstLetter(String firstLetter) {
		this.firstLetter = firstLetter;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getFactoryStatus() {
		return factoryStatus;
	}

	public void setFactoryStatus(Integer factoryStatus) {
		this.factoryStatus = factoryStatus;
	}

	public Integer getShowStatus() {
		return showStatus;
	}

	public void setShowStatus(Integer showStatus) {
		this.showStatus = showStatus;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public Integer getProductCommentCount() {
		return productCommentCount;
	}

	public void setProductCommentCount(Integer productCommentCount) {
		this.productCommentCount = productCommentCount;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getBigPic() {
		return bigPic;
	}

	public void setBigPic(String bigPic) {
		this.bigPic = bigPic;
	}

	public String getBrandStory() {
		return brandStory;
	}

	public void setBrandStory(String brandStory) {
		this.brandStory = brandStory;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PmsBrand{" + "id=" + id + ", name='" + name + '\'' + ", firstLetter='" + firstLetter + '\'' +
			   ", sort=" + sort + ", factoryStatus=" + factoryStatus + ", showStatus=" + showStatus +
			   ", productCount=" + productCount + ", productCommentCount=" + productCommentCount + ", logo='" + logo +
			   '\'' + ", bigPic='" + bigPic + '\'' + ", brandStory='" + brandStory + '\'' + '}';
	}
}


