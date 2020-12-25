/*
 *
 *  Copyright (c) 2018-2020 Givantha Kalansuriya, This source is a part of
 *   Staxrt - sample application source code.
 *   http://staxrt.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */

package com.staxrt.tutorial.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

/**
 * The type User.
 *
 */
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "application_number", nullable = false)
    private String applicationNum;

    @Column(name = "xx_field", nullable = false)
    private String xxField;

    @Column(name = "application_type", nullable = false)
    private String applicationType;
    
    @Column(name = "year", nullable = false)
    private String year;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "created_by", nullable = false)
    @CreatedBy
    private String createdBy;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @Column(name = "updated_by", nullable = false)
    @LastModifiedBy
    private String updatedBy;

  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
        return id;
    }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
        this.id = id;
    }

  /**
   * Gets Application Number.
   *
   * @return the Application Number
   */
  public String getApplicationNum() {
        return applicationNum;
    }

  /**
   * Sets Application Number.
   *
   * @param applicationNum the Application Number
   */
  public void setApplicationNum(String applicationNum) {
        this.applicationNum = applicationNum;
    }

  /**
   * Gets xx field.
   *
   * @return the xx field
   */
  public String getXxField() { return xxField; }

  /**
   * Sets xx field.
   *
   * @param xxField the xx field
   */
  public void setXxField(String xxField) {
        this.xxField = xxField;
    }

    /**
   * Gets application type.
   *
   * @return the application type
   */
  public String getApplicationType() { return applicationType;
  }
  /**
   * Sets application type.
   *
   * @param applicationType the application type
   */
  public void setApplicationType(String applicationType) { this.applicationType = applicationType; }

    /**
     * Gets year.
     *
     * @return the year
     */
    public String getYear() {
        return year;
    }
    /**
     * Sets year.
     *
     * @param year the year
     */
    public void setYear(String year) { this.year = year; }

    /**
     * Gets status.
     * @return the status
     */
    public String getStatus() { return status; }
    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
   * Gets created at.
   *
   * @return the created at
   */
  public Date getCreatedAt() {
        return createdAt;
    }

  /**
   * Sets created at.
   *
   * @param createdAt the created at
   */
  public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

  /**
   * Gets created by.
   *
   * @return the created by
   */
  public String getCreatedBy() {
        return createdBy;
    }

  /**
   * Sets created by.
   *
   * @param createdBy the created by
   */
  public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

  /**
   * Gets updated at.
   *
   * @return the updated at
   */
  public Date getUpdatedAt() {
        return updatedAt;
    }

  /**
   * Sets updated at.
   *
   * @param updatedAt the updated at
   */
  public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

  /**
   * Gets updated by.
   *
   * @return the updated by
   */
  public String getUpdatedBy() {
        return updatedBy;
    }

  /**
   * Sets updated by.
   *
   * @param updatedBy the updated by
   */
  public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", applicationNum='" + applicationNum + '\'' +
                ", xxField='" + xxField + '\'' +
                ", applicationType='" + applicationType + '\'' +
                ", year='" + year + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedAt=" + updatedAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }


}
