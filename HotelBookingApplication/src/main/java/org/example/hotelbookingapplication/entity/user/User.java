package org.example.hotelbookingapplication.entity.user;

import jakarta.persistence.*;
import lombok.*;
import org.example.hotelbookingapplication.entity.booking.Booking;
import org.example.hotelbookingapplication.entity.comment.Comment;
import org.example.hotelbookingapplication.entity.user.Role;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString(exclude = {"bookings", "comments"})
@EqualsAndHashCode(exclude = {"bookings", "comments"})
@Entity
@Table(name = "users")
public class User { //TODO поля данного класса не используются в рамках поставленной задачи (кроме id), при расширении ТЗ - доработать
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "birthdate")
    private LocalDate birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "is_blocked")
    private boolean isBlocked;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();


    public void addBooking(Booking booking){
        bookings.add(booking);
        booking.setUser(this);
    }

    public void removeBooking(Booking booking){
        bookings.remove(booking);
        booking.setUser(null);
    }

    public void addComment(Comment comment){
        comments.add(comment);
        comment.setUser(this);
    }

    public void deleteComment(Comment comment){
        comments.remove(comment);
        comment.setUser(null);
    }
}
