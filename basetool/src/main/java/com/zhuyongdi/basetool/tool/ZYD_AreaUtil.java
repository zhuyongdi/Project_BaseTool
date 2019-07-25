package com.zhuyongdi.basetool.tool;

import com.zhuyongdi.basetool.constants.ChinaAreaString;

public class ZYD_AreaUtil {

    /**
     * 是否市直辖市
     *
     * @param provinceOrCityName 省名或市名
     */
    public static boolean isMunicipalCity(String provinceOrCityName) {
        String city = provinceOrCityName;
        if ("市".equals(provinceOrCityName.charAt(provinceOrCityName.length() - 1) + "")) {
            city = provinceOrCityName.substring(0, provinceOrCityName.length() - 1);
        }
        for (String municipalCity : ChinaAreaString.MUNICIPAL_LIST) {
            if (municipalCity.equals(city)) {
                return true;
            }
        }
        return false;
    }

}
