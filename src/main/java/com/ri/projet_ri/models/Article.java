package com.ri.projet_ri.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

//@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Article {
      String identifiantArticle;
      String urlArticle;
      String sourceArticle;
      String thematiqueArticle;
      String sousCategorieArticle;
      List<String> imagesArticle;
      String titreArticle;
      String resumeArticle;
      String auteurArticle;
      String datePublicationArticle;
      String dateMiseJourArticle;
      List<String> videosArticle;
      int nombreLikesArticle;
      int nombreLecturesArticle;
      int nombreCommentairesArticle;
      int nombrePartagesArticle;
      String contenuArticle;
      List<String> commentairesArticle;
      String dateCollecteArticle;
      String motsClesArticle;
}
