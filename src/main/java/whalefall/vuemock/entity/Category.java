package whalefall.vuemock.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Category {
    public static Category getInstance() {
        Category instance = new Category();
        instance.setCategoryId(1);
        instance.setCategoryName("电脑、办公");

        ArrayList clist = new ArrayList();
        Category cCategory1 = new Category();
        Category cCategory2 = new Category();
        Category cCategory3 = new Category();

        clist.add(cCategory1);
        clist.add(cCategory2);
        clist.add(cCategory3);
        instance.setChildCategory(clist);
        ArrayList cclist = new ArrayList();
        Category ccCategory1 = new Category();
        cclist.add(ccCategory1);
        cCategory1.setChildCategory(cclist);

        cCategory1.setCategoryId(1);
        cCategory1.setCategoryName("电子书");
        cCategory2.setCategoryId(2);
        cCategory2.setCategoryName("数字音乐");
        cCategory3.setCategoryId(3);
        cCategory3.setCategoryName("音像");
        ccCategory1.setCategoryId(1);
        ccCategory1.setCategoryName("视频");


        return instance;

    }

    private int categoryId;
    private String categoryName;
    private ArrayList childCategory;
}
