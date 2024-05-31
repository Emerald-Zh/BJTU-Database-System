package com.manage.project.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName worker
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker implements Serializable {
    /**
     * 
     */
    private Integer workerId;

    /**
     * 
     */
    private String workerName;

    /**
     * 
     */
    private String workerSex;

    /**
     * 
     */
    private Integer workerAge;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getWorkerId() {
        return workerId;
    }

    /**
     * 
     */
    public void setWorkerId(Integer workerId) {
        this.workerId = workerId;
    }

    /**
     * 
     */
    public String getWorkerName() {
        return workerName;
    }

    /**
     * 
     */
    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    /**
     * 
     */
    public String getWorkerSex() {
        return workerSex;
    }

    /**
     * 
     */
    public void setWorkerSex(String workerSex) {
        this.workerSex = workerSex;
    }

    /**
     * 
     */
    public Integer getWorkerAge() {
        return workerAge;
    }

    /**
     * 
     */
    public void setWorkerAge(Integer workerAge) {
        this.workerAge = workerAge;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Worker other = (Worker) that;
        return (this.getWorkerId() == null ? other.getWorkerId() == null : this.getWorkerId().equals(other.getWorkerId()))
            && (this.getWorkerName() == null ? other.getWorkerName() == null : this.getWorkerName().equals(other.getWorkerName()))
            && (this.getWorkerSex() == null ? other.getWorkerSex() == null : this.getWorkerSex().equals(other.getWorkerSex()))
            && (this.getWorkerAge() == null ? other.getWorkerAge() == null : this.getWorkerAge().equals(other.getWorkerAge()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getWorkerId() == null) ? 0 : getWorkerId().hashCode());
        result = prime * result + ((getWorkerName() == null) ? 0 : getWorkerName().hashCode());
        result = prime * result + ((getWorkerSex() == null) ? 0 : getWorkerSex().hashCode());
        result = prime * result + ((getWorkerAge() == null) ? 0 : getWorkerAge().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", workerId=").append(workerId);
        sb.append(", workerName=").append(workerName);
        sb.append(", workerSex=").append(workerSex);
        sb.append(", workerAge=").append(workerAge);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}