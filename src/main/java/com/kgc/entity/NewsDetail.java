package com.kgc.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public class NewsDetail implements Serializable {

    private static final long serialVersionUID=1L;

      /**
     * 新闻编号
     */
        private Integer id;

      /**
     * 新闻名称
     */
      private String title;

      /**
     * 内容摘要
     */
      private String summary;

      /**
     * 作者
     */
      private String author;

      /**
     * 创建时间
     */
      private LocalDate createDate;

    private LocalDateTime updateDate;

    private Integer version;

    private Integer state;

    private Integer deleted;


}
