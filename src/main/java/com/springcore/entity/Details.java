package com.springcore.entity;

import java.util.Properties;

public class Details {
private Properties detail;

public Properties getDetail() {
	return detail;
}

public void setDetail(Properties detail) {
	this.detail = detail;
}

@Override
public String toString() {
	return "Details [detail=" + detail + "]";
}

}
