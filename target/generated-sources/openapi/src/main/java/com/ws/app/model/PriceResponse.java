package com.ws.app.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * PriceResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PriceResponse   {
  @JsonProperty("priceList")
  private Long priceList;

  @JsonProperty("date")
  private String date;

  @JsonProperty("product")
  private Integer product;

  @JsonProperty("brand")
  private Integer brand;

  @JsonProperty("price")
  private BigDecimal price;

  public PriceResponse priceList(Long priceList) {
    this.priceList = priceList;
    return this;
  }

  /**
   * id
   * @return priceList
  */
  @ApiModelProperty(example = "1", value = "id")


  public Long getPriceList() {
    return priceList;
  }

  public void setPriceList(Long priceList) {
    this.priceList = priceList;
  }

  public PriceResponse date(String date) {
    this.date = date;
    return this;
  }

  /**
   * fecha inicio del precio
   * @return date
  */
  @ApiModelProperty(example = "2020-06-15T16:00:00", value = "fecha inicio del precio")


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public PriceResponse product(Integer product) {
    this.product = product;
    return this;
  }

  /**
   * id del producto
   * @return product
  */
  @ApiModelProperty(example = "1", value = "id del producto")


  public Integer getProduct() {
    return product;
  }

  public void setProduct(Integer product) {
    this.product = product;
  }

  public PriceResponse brand(Integer brand) {
    this.brand = brand;
    return this;
  }

  /**
   * id del producto
   * @return brand
  */
  @ApiModelProperty(example = "1", value = "id del producto")


  public Integer getBrand() {
    return brand;
  }

  public void setBrand(Integer brand) {
    this.brand = brand;
  }

  public PriceResponse price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * precio del producto
   * @return price
  */
  @ApiModelProperty(example = "36.4", value = "precio del producto")

  @Valid

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceResponse priceResponse = (PriceResponse) o;
    return Objects.equals(this.priceList, priceResponse.priceList) &&
        Objects.equals(this.date, priceResponse.date) &&
        Objects.equals(this.product, priceResponse.product) &&
        Objects.equals(this.brand, priceResponse.brand) &&
        Objects.equals(this.price, priceResponse.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priceList, date, product, brand, price);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceResponse {\n");
    
    sb.append("    priceList: ").append(toIndentedString(priceList)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

