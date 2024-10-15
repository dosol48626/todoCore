package com.dosol.todocore.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    @Builder.Default
    @Min(value = 3)
    @Max(value = 100)
    @Positive
    private int size = 3;

    private String link;

    private String[] types;
    private String keyword;
    private boolean finished;
    private LocalDate from;
    private LocalDate to;

    public int getSkip() {
        return (page - 1) * size;
    }

//    public String getLink(){
//        //부를때 그냥 .Link하면 써짐
//        StringBuilder builder = new StringBuilder();
//        builder.append("page=" + this.page);
//        builder.append("&size=" + this.size);
//
//        return builder.toString();
//    }

    public String getLink(){
        StringBuilder builder = new StringBuilder();
        builder.append("page="+this.page);
        builder.append("&size="+this.size);
        if(finished) {
            builder.append("&finished=on");
        }
        if(types!=null && types.length>0){
            for(int i=0; i<types.length; i++){
                builder.append("&types="+types[i]);
            }
        }
        if(keyword!=null){
            builder.append("&keyword="+keyword);
        }
        if(from!=null){
            builder.append("&from="+from.toString());
        }
        if(to!=null){
            builder.append("&to="+to.toString());
        }
        return builder.toString();
    }
    public boolean checkType(String type){
        if(types==null || types.length==0){
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }

}