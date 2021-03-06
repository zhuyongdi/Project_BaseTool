package com.zhuyongdi.basetool.constants;

import java.util.Hashtable;

/**
 * 中国地区代码
 * Created by ZhuYongdi on 2019/4/18.
 */
public class XXChinaAreaIDCode {

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
    public static final String GUANG_XI = "45";

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
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.BEI_JING, XXChinaAreaString.BEI_JING);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.TIAN_JIN, XXChinaAreaString.TIAN_JIN);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.HE_BEI, XXChinaAreaString.HE_BEI);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.SHAN_XI, XXChinaAreaString.SHAN_XI);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.NEI_MENG_GU, XXChinaAreaString.NEI_MENG_GU);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.LIAO_NING, XXChinaAreaString.LIAO_NING);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.JI_LIN, XXChinaAreaString.JI_LIN);

        AREA_CODE_TABLE.put(XXChinaAreaIDCode.HEI_LONG_JIANG, XXChinaAreaString.HEI_LONG_JIANG);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.SHANG_HAI, XXChinaAreaString.SHANG_HAI);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.JIANG_SU, XXChinaAreaString.JIANG_SU);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.ZHE_JIANG, XXChinaAreaString.ZHE_JIANG);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.AN_HUI, XXChinaAreaString.AN_HUI);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.FU_JIAN, XXChinaAreaString.FU_JIAN);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.JIANG_XI, XXChinaAreaString.JIANG_XI);

        AREA_CODE_TABLE.put(XXChinaAreaIDCode.SHAN_DONG, XXChinaAreaString.SHAN_DONG);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.HE_NAN, XXChinaAreaString.HE_NAN);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.HU_BEI, XXChinaAreaString.HU_BEI);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.HU_NAN, XXChinaAreaString.HU_NAN);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.GUANG_DONG, XXChinaAreaString.GUANG_DONG);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.GUANG_XI, XXChinaAreaString.GUANG_XI);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.HAI_NAN, XXChinaAreaString.HAI_NAN);

        AREA_CODE_TABLE.put(XXChinaAreaIDCode.CHONG_QING, XXChinaAreaString.CHONG_QING);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.SI_CHUANG, XXChinaAreaString.SI_CHUANG);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.GUI_ZHOU, XXChinaAreaString.GUI_ZHOU);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.YUN_NAN, XXChinaAreaString.YUN_NAN);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.XI_ZANG, XXChinaAreaString.XI_ZANG);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.SAN_XI, XXChinaAreaString.SAN_XI);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.GAN_SU, XXChinaAreaString.GAN_SU);

        AREA_CODE_TABLE.put(XXChinaAreaIDCode.QING_HAI, XXChinaAreaString.QING_HAI);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.NING_XIA, XXChinaAreaString.NING_XIA);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.XIN_JIANG, XXChinaAreaString.XIN_JIANG);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.TAI_WAN, XXChinaAreaString.TAI_WAN);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.XIANG_GANG, XXChinaAreaString.XIANG_GANG);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.AO_MEN, XXChinaAreaString.AO_MEN);
        AREA_CODE_TABLE.put(XXChinaAreaIDCode.GUO_WAI, XXChinaAreaString.GUO_WAI);

    }

}
