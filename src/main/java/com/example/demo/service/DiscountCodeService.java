@Service
public class DiscountCodeService {

    private final DiscountCodeRepository repository;

    public DiscountCodeService(DiscountCodeRepository repository) {
        this.repository = repository;
    }

    public DiscountCode createDiscountCode(DiscountCode discountCode) {
        return repository.save(discountCode);
    }

    public List<DiscountCode> getAllDiscountCodes() {
        return repository.findAll();
    }

    public Optional<DiscountCode> getDiscountCodeById(Long id) {
        return repository.findById(id);
    }

    public DiscountCode updateDiscountCode(Long id, DiscountCode discountCode) {
        return repository.findById(id).map(existing -> {
            existing.setCode(discountCode.getCode());
            existing.setInfluencer(discountCode.getInfluencer());
            existing.setCampaign(discountCode.getCampaign());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("DiscountCode not found"));
    }

    public void deleteDiscountCode(Long id) {
        repository.deleteById(id);
    }
}
