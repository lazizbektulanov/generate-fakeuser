package uz.task6.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String identifier;
    private String fullName;
    private String address;
    private String phoneNumber;
    private int orderNum;
}
