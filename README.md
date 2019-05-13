该依赖所引用的第三方依赖:

     /* recyclerview */
     implementation 'com.android.support:recyclerview-v7:28.0.0'

     /* design */
     implementation 'com.android.support:design:28.0.0'

     /* glide */
     implementation 'com.github.bumptech.glide:glide:4.7.1'
     implementation 'com.github.open-android:Glide-transformations:0.1.0'

该依赖使用时的注意事项:

     使用本库的ScreenAdapterTool在Application以及清单文件中注册,因为以下引用了ScreenAdapterTool:
     * LoadingDialog
     * PermissionDialog
     * AndImageSelect
     ScreenAdapterTool设计参数:
     <meta-data
         android:name="design_width"
         android:value="1080" />
     <meta-data
         android:name="design_dpi"
         android:value="320" />
     <meta-data
         android:name="font_size"
         android:value="1.0" />
     <meta-data
         android:name="unit"
         android:value="px" />


