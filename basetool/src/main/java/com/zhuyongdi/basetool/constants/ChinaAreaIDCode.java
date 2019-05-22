package com.zhuyongdi.basetool.constants;

import java.util.Hashtable;

/**
 * 中国地区代码
 * Created by ZhuYongdi on 2019/4/18.
 */
public class ChinaAreaIDCode {

    /**
     * 北京
     */
    public static final String BEI_JING = "11";

    /**
     * 天津
     */
    public static final String TIAN_JIN = "12";

    /**
     * 河北
     */
    public static final String HE_BEI = "13";

    /**
     * 山西
     */
    public static final String SHAN_XI = "14";

    /**
     * 内蒙古
     */
    public static final String NEI_MENG_GU = "15";

    /**
     * 辽宁
     */
    public static final String LIAO_NING = "21";

    /**
     * 吉林
     */
    public static final String JI_LIN = "22";

    /**
     * 黑龙江
     */
    public static final String HEI_LONG_JIANG = "23";

    /**
     * 上海
     */
    public static final String SHANG_HAI = "31";

    /**
     * 江苏
     */
    public static final String JIANG_SU = "32";

    /**
     * 浙江
     */
    public static final String ZHE_JIANG = "33";

    /**
     * 安徽
     */
    public static final String AN_HUI = "34";

    /**
     * 福建
     */
    public static final String FU_JIAN = "35";

    /**
     * 江西
     */
    public static final String JIANG_XI = "36";

    /**
     * 山东
     */
    public static final String SHAN_DONG = "37";

    /**
     * 河南
     */
    public static final String HE_NAN = "41";

    /**
     * 湖北
     */
    public static final String HU_BEI = "42";

    /**
     * 湖南
     */
    public static final String HU_NAN = "43";

    /**
     * 广东
     */
    public static final String GUANG_DONG = "44";

    /**
     * 广西
     */
    public static final String GOANG_XI = "45";

    /**
     * 海南
     */
    public static final String HAI_NAN = "46";

    /**
     * 重庆
     */
    public static final String CHONG_QING = "50";

    /**
     * 四川
     */
    public static final String SI_CHUANG = "51";

    /**
     * 贵州
     */
    public static final String GUI_ZHOU = "52";

    /**
     * 云南
     */
    public static final String YUN_NAN = "53";

    /**
     * 西藏
     */
    public static final String XI_ZANG = "54";

    /**
     * 陕西
     */
    public static final String SAN_XI = "61";

    /**
     * 甘肃
     */
    public static final String GAN_SU = "62";

    /**
     * 青海
     */
    public static final String QING_HAI = "63";

    /**
     * 宁夏
     */
    public static final String NING_XIA = "64";

    /**
     * 新疆
     */
    public static final String XIN_JIANG = "65";

    /**
     * 台湾
     */
    public static final String TAI_WAN = "71";

    /**
     * 香港
     */
    public static final String XIANG_GANG = "81";

    /**
     * 澳门
     */
    public static final String AO_MEN = "82";

    /**
     * 国外
     */
    public static final String GUO_WAI = "91";

    /**
     * 中国<名称,编码>集合
     */
    public static final Hashtable<String, String> AREA_CODE_TABLE = new Hashtable<>();

    static {
        AREA_CODE_TABLE.put(ChinaAreaIDCode.BEI_JING, ChinaAreaString.BEI_JING);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.TIAN_JIN, ChinaAreaString.TIAN_JIN);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.HE_BEI, ChinaAreaString.HE_BEI);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.SHAN_XI, ChinaAreaString.SHAN_XI);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.NEI_MENG_GU, ChinaAreaString.NEI_MENG_GU);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.LIAO_NING, ChinaAreaString.LIAO_NING);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.JI_LIN, ChinaAreaString.JI_LIN);

        AREA_CODE_TABLE.put(ChinaAreaIDCode.HEI_LONG_JIANG, ChinaAreaString.HEI_LONG_JIANG);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.SHANG_HAI, ChinaAreaString.SHANG_HAI);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.JIANG_SU, ChinaAreaString.JIANG_SU);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.ZHE_JIANG, ChinaAreaString.ZHE_JIANG);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.AN_HUI, ChinaAreaString.AN_HUI);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.FU_JIAN, ChinaAreaString.FU_JIAN);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.JIANG_XI, ChinaAreaString.JIANG_XI);

        AREA_CODE_TABLE.put(ChinaAreaIDCode.SHAN_DONG, ChinaAreaString.SHAN_DONG);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.HE_NAN, ChinaAreaString.HE_NAN);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.HU_BEI, ChinaAreaString.HU_BEI);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.HU_NAN, ChinaAreaString.HU_NAN);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.GUANG_DONG, ChinaAreaString.GUANG_DONG);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.GOANG_XI, ChinaAreaString.GOANG_XI);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.HAI_NAN, ChinaAreaString.HAI_NAN);

        AREA_CODE_TABLE.put(ChinaAreaIDCode.CHONG_QING, ChinaAreaString.CHONG_QING);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.SI_CHUANG, ChinaAreaString.SI_CHUANG);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.GUI_ZHOU, ChinaAreaString.GUI_ZHOU);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.YUN_NAN, ChinaAreaString.YUN_NAN);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.XI_ZANG, ChinaAreaString.XI_ZANG);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.SAN_XI, ChinaAreaString.SAN_XI);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.GAN_SU, ChinaAreaString.GAN_SU);

        AREA_CODE_TABLE.put(ChinaAreaIDCode.QING_HAI, ChinaAreaString.QING_HAI);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.NING_XIA, ChinaAreaString.NING_XIA);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.XIN_JIANG, ChinaAreaString.XIN_JIANG);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.TAI_WAN, ChinaAreaString.TAI_WAN);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.XIANG_GANG, ChinaAreaString.XIANG_GANG);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.AO_MEN, ChinaAreaString.AO_MEN);
        AREA_CODE_TABLE.put(ChinaAreaIDCode.GUO_WAI, ChinaAreaString.GUO_WAI);

    }

}
