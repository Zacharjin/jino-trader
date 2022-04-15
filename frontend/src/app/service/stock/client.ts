import { map, Observable, Observer, Subject } from 'rxjs';
import { Stock } from './stock';
export class StockClient {

    constructor(private url: string) { }

    public connect(): Observable<Stock> {
        const subject: Subject<MessageEvent> = this.create(this.url);
        return subject.pipe(
            map(this.convertToStock)
        );
    }

    private convertToStock(response: MessageEvent): Stock {
        const content = JSON.parse(response.data);
        return {
            value: content.value,
        };
    }

    private create(url: string): Subject<MessageEvent> {
        let wsc = new WebSocket(url);

        let observable = Observable.create((obs: Observer<MessageEvent>) => {
            wsc.onmessage = obs.next.bind(obs);
            wsc.onerror = obs.error.bind(obs);
            wsc.onclose = obs.complete.bind(obs);
            return wsc.close.bind(wsc);
        });
        let observer = {
            next: (data: Object) => {
                if (wsc.readyState === WebSocket.OPEN) {
                    wsc.send(JSON.stringify(data));
                }
            },
        };
        return Subject.create(observer, observable);
    }
}