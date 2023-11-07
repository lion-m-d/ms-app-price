package com.ws.app.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.jackson.nullable.JsonNullable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RequestPriceFilter
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class RequestPriceFilter   {
  @JsonProperty("date")
  private String date;

  @JsonProperty("hour")
  private String hour;

  @JsonProperty("product")
  private Integer product;

  @JsonProperty("brand")
  private Integer brand;

  public RequestPriceFilter date(String date) {
    this.date = date;
    return this;
  }

  /**
   * Date parameter
   * @return date
  */
  @ApiModelProperty(example = "2020-12-31", required = true, value = "Date parameter")
  @NotNull


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public RequestPriceFilter hour(String hour) {
    this.hour = hour;
    return this;
  }

  /**
   * Hour parameter
   * @return hour
  */
  @ApiModelProperty(example = "10:00", required = true, value = "Hour parameter")
  @NotNull


  public String getHour() {
    return hour;
  }

  public void setHour(String hour) {
    this.hour = hour;
  }

  public RequestPriceFilter product(Integer product) {
    this.product = product;
    return this;
  }

  /**
   * Product ID parameter
   * @return product
  */
  @ApiModelProperty(example = "35455", required = true, value = "Product ID parameter")
  @NotNull


  public Integer getProduct() {
    return product;
  }

  public void setProduct(Integer product) {
    this.product = product;
  }

  public RequestPriceFilter brand(Integer brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Brand ID parameter
   * @return brand
  */
  @ApiModelProperty(example = "1", required = true, value = "Brand ID parameter")
  @NotNull


  public Integer getBrand() {
    return brand;
  }

  public void setBrand(Integer brand) {
    this.brand = brand;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RequestPriceFilter requestPriceFilter = (RequestPriceFilter) o;
    return Objects.equals(this.date, requestPriceFilter.date) &&
        Objects.equals(this.hour, requestPriceFilter.hour) &&
        Objects.equals(this.product, requestPriceFilter.product) &&
        Objects.equals(this.brand, requestPriceFilter.brand);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, hour, product, brand);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RequestPriceFilter {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    hour: ").append(toIndentedString(hour)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
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

