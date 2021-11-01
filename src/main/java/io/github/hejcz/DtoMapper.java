package io.github.hejcz;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Collection;
import java.util.List;

record DtoWishRecipient(Integer id, String text, String url,
                        Integer power) {
}

record Wish(Integer id, String title, String url, Integer power) {
}

record WishList(List<Wish> wishes, boolean locked) {
}

record WishList2(boolean isLocked, Collection<DtoWishRecipient> wishes) {
}

@Mapper
public interface DtoMapper {

    DtoMapper INSTANCE = Mappers.getMapper(DtoMapper.class);

    @Mapping(source = "text", target = "title")
    Wish mapWish(DtoWishRecipient wish);

    WishList mapWishlist(WishList2 wishlist);
}