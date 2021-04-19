package hu.szabo.painmeasure.utils;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse implements Serializable{

	private static final long serialVersionUID = 2474567940988060001L;

	private Boolean success;

	private String message;

	@Override
	public String toString() {
		return "BaseResponse [success=" + success + ", message=" + message + "]";
	}
}
