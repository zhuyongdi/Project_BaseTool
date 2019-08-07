package com.zhuyongdi.basetool.constants;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ZhuYongdi on 2019/4/18.
 */
public class XXChinaAreaString {

    /**
     * 北京
     */
    public static final String BEI_JING = "北京";

    /**
     * 天津
     */
    public static final String TIAN_JIN = "天津";

    /**
     * 河北
     */
    public static final String HE_BEI = "河北";

    /**
     * 山西
     */
    public static final String SHAN_XI = "山西";

    /**
     * 内蒙古
     */
    public static final String NEI_MENG_GU = "内蒙古";

    /**
     * 辽宁
     */
    public static final String LIAO_NING = "辽宁";

    /**
     * 吉林
     */
    public static final String JI_LIN = "吉林";

    /**
     * 黑龙江
     */
    public static final String HEI_LONG_JIANG = "黑龙江";

    /**
     * 上海
     */
    public static final String SHANG_HAI = "上海";

    /**
     * 江苏
     */
    public static final String JIANG_SU = "江苏";

    /**
     * 浙江
     */
    public static final String ZHE_JIANG = "浙江";

    /**
     * 安徽
     */
    public static final String AN_HUI = "安徽";

    /**
     * 福建
     */
    public static final String FU_JIAN = "福建";

    /**
     * 江西
     */
    public static final String JIANG_XI = "江西";

    /**
     * 山东
     */
    public static final String SHAN_DONG = "山东";

    /**
     * 河南
     */
    public static final String HE_NAN = "河南";

    /**
     * 湖北
     */
    public static final String HU_BEI = "湖北";

    /**
     * 湖南
     */
    public static final String HU_NAN = "湖南";

    /**
     * 广东
     */
    public static final String GUANG_DONG = "广东";

    /**
     * 广西
     */
    public static final String GUANG_XI = "广西";

    /**
     * 海南
     */
    public static final String HAI_NAN = "海南";

    /**
     * 重庆
     */
    public static final String CHONG_QING = "重庆";

    /**
     * 四川
     */
    public static final String SI_CHUANG = "四川";

    /**
     * 贵州
     */
    public static final String GUI_ZHOU = "贵州";

    /**
     * 云南
     */
    public static final String YUN_NAN = "云南";

    /**
     * 西藏
     */
    public static final String XI_ZANG = "西藏";

    /**
     * 陕西
     */
    public static final String SAN_XI = "陕西";

    /**
     * 甘肃
     */
    public static final String GAN_SU = "甘肃";

    /**
     * 青海
     */
    public static final String QING_HAI = "青海";

    /**
     * 宁夏
     */
    public static final String NING_XIA = "宁夏";

    /**
     * 新疆
     */
    public static final String XIN_JIANG = "新疆";

    /**
     * 台湾
     */
    public static final String TAI_WAN = "台湾";

    /**
     * 香港
     */
    public static final String XIANG_GANG = "香港";

    /**
     * 澳门
     */
    public static final String AO_MEN = "澳门";

    /**
     * 国外
     */
    public static final String GUO_WAI = "国外";

    /**
     * 中国所有省份(包括直辖市,自治区,省级行政单位,特别行政区)的集合
     */
    public static final List<String> ALL_LIST = Arrays.asList(BEI_JING, TIAN_JIN, HE_BEI, SHAN_XI, NEI_MENG_GU, LIAO_NING, JI_LIN, HEI_LONG_JIANG, SHANG_HAI, JIANG_SU, ZHE_JIANG, AN_HUI, FU_JIAN, JIANG_XI, SHAN_DONG, HE_NAN, HU_BEI, HU_NAN, GUANG_DONG, GUANG_XI, HAI_NAN, CHONG_QING, SI_CHUANG, GUI_ZHOU, YUN_NAN, XI_ZANG, SAN_XI, GAN_SU, QING_HAI, NING_XIA, XIN_JIANG, TAI_WAN, XIANG_GANG, AO_MEN, GUO_WAI);

    /**
     * 中国直辖市集合
     * 4个:北京,天津,上海,重庆
     */
    public static final List<String> MUNICIPAL_LIST = Arrays.asList(BEI_JING, TIAN_JIN, SHANG_HAI, CHONG_QING);

    /**
     * 中国自治区集合
     * 5个:新疆,西藏,宁夏,内蒙古,广西
     */
    public static final List<String> AUTONOMOUS_AREA_LIST = Arrays.asList(XIN_JIANG, XI_ZANG, NING_XIA, NEI_MENG_GU, GUANG_XI);

    /**
     * 中国特别行政区集合
     * 2个:香港,澳门
     */
    public static final List<String> Special_Administrative_REGION_LIST = Arrays.asList(XIANG_GANG, AO_MEN);

}
