package com.huahai.wanxiang.service.service;

import com.google.common.collect.Lists;
import com.huahai.wanxiang.service.dto.ArticleInfoDTO;
import jxl.Workbook;
import jxl.biff.Type;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.biff.CellValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class DownloadServiceImpl implements DownloadService {
    @Autowired
    private ArticleService articleService;
    private String fileName = "虾皮商品批量上传文件.xlsx";
    @Override
    public void downloadArticle(String ids, HttpServletResponse response) {
        String[] idArr = ids.split(",");
        List<Long> idList = Lists.newLinkedList();
        for (String id : idArr) {
            idList.add(Long.valueOf(id));
        }
        List<ArticleInfoDTO> articleInfoDTOList = articleService.getArticleByIdList(idList);
        if (CollectionUtils.isEmpty(articleInfoDTOList)) {
            return ;
        }
        try {
            WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());
            WritableSheet sheet = workbook.createSheet("商品列表",0);
            WritableCell articleName = new Label(0,0,"商品名称");
            WritableCell articleDesc = new Label(1,0,"商品描述");
            WritableCell price = new Label(2,0,"全球商品价格");
            WritableCell coverPhoto = new Label(3,0,"封面图片");
            WritableCell weight = new Label(4,0,"重量");
            sheet.addCell(articleName);
            sheet.addCell(articleDesc);
            sheet.addCell(price);
            sheet.addCell(coverPhoto);
            sheet.addCell(weight);

            for (int i=0; i<articleInfoDTOList.size(); i++) {
                ArticleInfoDTO articleInfoDTO = articleInfoDTOList.get(i);
                WritableCell articleNameValue = new Label(0,i+1,articleInfoDTO.getArticleName());
                WritableCell articleValue = new Label(1,i+1,articleInfoDTO.getArticleName());
                WritableCell priceValue = new Label(2,i+1,articleInfoDTO.getOriginalPrice().toString());
                WritableCell coverPhotoValue = new Label(3,i+1,articleInfoDTO.getCoverPhoto());
                WritableCell weightValue = new Label(4,i+1,articleInfoDTO.getWeight().toString());
                sheet.addCell(articleNameValue);
                sheet.addCell(articleValue);
                sheet.addCell(priceValue);
                sheet.addCell(coverPhotoValue);
                sheet.addCell(weightValue);
            }

            workbook.write();
            workbook.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
