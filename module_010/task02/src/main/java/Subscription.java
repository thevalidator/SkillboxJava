import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Column(name = "subscription_date")
    protected LocalDateTime subscriptionDate;

    protected Subscription() {
    }

    public Subscription(LocalDateTime subscriptionDate) {

        this.subscriptionDate = subscriptionDate;
    }

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(LocalDateTime subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

}
