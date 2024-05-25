package com.kgc.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author admin
 * @since 2023-09-10
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class NewsComment implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 编号
     */
        @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 新闻编号
     */
      private Integer newsid;

      /**
     * 评论内容
     */
      private String content;

      /**
     * 评论人
     */
      private String author;

      /**
     * 评论时间
     */
      @TableField("createDate")
    private LocalDate createDate;


}
