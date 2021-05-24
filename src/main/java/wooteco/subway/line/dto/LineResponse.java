package wooteco.subway.line.dto;

import java.util.List;
import java.util.stream.Collectors;
import wooteco.subway.line.domain.Line;

public class LineResponse {

    private Long id;
    private String name;
    private String color;
    private List<SectionResponse> sections;

    public LineResponse() {
    }

    public LineResponse(Long id, String name, String color, List<SectionResponse> sections) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.sections = sections;
    }

    public static LineResponse of(Line line) {
        List<SectionResponse> sections = line.getSortedSections().stream()
            .map(it -> SectionResponse.of(it))
            .collect(Collectors.toList());
        return new LineResponse(line.getId(), line.getName(), line.getColor(), sections);
    }

    public static List<LineResponse> listOf(List<Line> lines) {
        return lines.stream()
            .map(LineResponse::of)
            .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<SectionResponse> getSections() {
        return sections;
    }
}
