package oxygenfactory.com.sasit.module.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public final class DateTools {

	// 获取本月的开始时间
	public static String getBeginDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		return getDayStartTime(calendar.getTime());
	}

	// 获取本月的结束时间
	public static String getEndDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(getNowYear(), getNowMonth() - 1, 1);
		int day = calendar.getActualMaximum(5);
		calendar.set(getNowYear(), getNowMonth() - 1, day);
		return getDayEndTime(calendar.getTime());
	}

	public static Integer getNowYear() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return Integer.valueOf(gc.get(1));
	}

	public static int getNowMonth() {
		Date date = new Date();
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		return gc.get(2) + 1;
	}

	public static String getDayStartTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d) {
			calendar.setTime(d);
		}
		int dayMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), dayMonth, 0, 0, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date(calendar.getTimeInMillis()));
	}

	public static String getDayEndTime(Date d) {
		Calendar calendar = Calendar.getInstance();
		if (null != d) {
			calendar.setTime(d);
		}
		int dayMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), dayMonth, 23, 59, 59);
		calendar.set(Calendar.MILLISECOND, 999);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date(calendar.getTimeInMillis()));
	}

	public static void main(String[] args) {
		System.out.println(getBeginDayOfMonth());
		System.out.println(getEndDayOfMonth());
	}
}
