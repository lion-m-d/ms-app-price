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
 * PricesResponse
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PricesResponse   {
  @JsonProperty("priceList")
  private Long priceList;

  @JsonProperty("startDate")
  private String startDate;

  @JsonProperty("endDate")
  private String endDate;

  @JsonProperty("product")
  private String product;

  @JsonProperty("brand")
  private String brand;

  @JsonProperty("priority")
  private String priority;

  @JsonProperty("price")
  private BigDecimal price;

  @JsonProperty("currency")
  private String currency;

  public PricesResponse priceList(Long priceList) {
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

  public PricesResponse startDate(String startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * fecha inicio del precio
   * @return startDate
  */
  @ApiModelProperty(example = "2020-06-15T16:00:00", value = "fecha inicio del precio")


  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public PricesResponse endDate(String endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * fecha fin del precio
   * @return endDate
  */
  @ApiModelProperty(example = "2020-12-31T23:59:59", value = "fecha fin del precio")


  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public PricesResponse product(String product) {
    this.product = product;
    return this;
  }

  /**
   * Nombre del producto
   * @return product
  */
  @ApiModelProperty(example = "Jeans", value = "Nombre del producto")


  public String getProduct() {
    return product;
  }

  public void setProduct(String product) {
    this.product = product;
  }

  public PricesResponse brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Marca del producto
   * @return brand
  */
  @ApiModelProperty(example = "ZARA", value = "Marca del producto")


  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public PricesResponse priority(String priority) {
    this.priority = priority;
    return this;
  }

  /**
   * prioridad del precio del product
   * @return priority
  */
  @ApiModelProperty(example = "1", value = "prioridad del precio del product")


  public String getPriority() {
    return priority;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public PricesResponse price(BigDecimal price) {
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

  public PricesResponse currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Tipo de moneta
   * @return currency
  */
  @ApiModelProperty(example = "EUR", value = "Tipo de moneta")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PricesResponse pricesResponse = (PricesResponse) o;
    return Objects.equals(this.priceList, pricesResponse.priceList) &&
        Objects.equals(this.startDate, pricesResponse.startDate) &&
        Objects.equals(this.endDate, pricesResponse.endDate) &&
        Objects.equals(this.product, pricesResponse.product) &&
        Objects.equals(this.brand, pricesResponse.brand) &&
        Objects.equals(this.priority, pricesResponse.priority) &&
        Objects.equals(this.price, pricesResponse.price) &&
        Objects.equals(this.currency, pricesResponse.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(priceList, startDate, endDate, product, brand, priority, price, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PricesResponse {\n");
    
    sb.append("    priceList: ").append(toIndentedString(priceList)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    priority: ").append(toIndentedString(priority)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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

