import { Component, Input } from "@angular/core";

@Component({
    selector: "comment-item",
    templateUrl: "./comment.html"
})
export class CommentComponent{
    @Input() comment = {
        id: 0,
        text: '',
        publishdate: '',
        votes: '',
        username: '',
    }
}